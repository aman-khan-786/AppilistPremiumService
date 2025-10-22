package com.appilistpremiumservice.domain.usecase.auth

import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.data.local.entity.toEntity
import com.appilistpremiumservice.domain.model.User
import com.appilistpremiumservice.domain.model.UserRole
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

/**
 * Signup Use Case
 * Handles new user registration
 */
class SignupUseCase(private val database: AppDatabase) {
    
    suspend operator fun invoke(
        name: String,
        email: String,
        password: String,
        shopId: String = ""
    ): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                // Check if email already exists
                val existingUser = database.userDao().getUserByEmail(email)
                if (existingUser != null) {
                    return@withContext Result.failure(Exception("Email already registered"))
                }
                
                // Create new user
                val newUser = User(
                    id = UUID.randomUUID().toString(),
                    name = name,
                    email = email,
                    password = password,
                    role = UserRole.STAFF,
                    shopId = shopId,
                    isApproved = false,
                    createdAt = System.currentTimeMillis(),
                    updatedAt = System.currentTimeMillis()
                )
                
                database.userDao().insertUser(newUser.toEntity())
                Result.success(newUser)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}