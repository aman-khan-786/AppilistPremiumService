package com.appilistpremiumservice.domain.usecase.auth

import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Login Use Case
 * Handles user login business logic
 */
class LoginUseCase(private val database: AppDatabase) {
    
    suspend operator fun invoke(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                val userEntity = database.userDao().login(email, password)
                
                if (userEntity != null) {
                    if (userEntity.isApproved) {
                        Result.success(userEntity.toDomain())
                    } else {
                        Result.failure(Exception("Account pending approval"))
                    }
                } else {
                    Result.failure(Exception("Invalid email or password"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}