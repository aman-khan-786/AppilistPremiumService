package com.appilistpremiumservice.data.repository

import com.appilistpremiumservice.data.local.dao.UserDao
import com.appilistpremiumservice.data.local.entity.UserEntity
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepository(private val userDao: UserDao) {
    
    suspend fun insertUser(user: UserEntity) = userDao.insertUser(user)
    
    suspend fun getUserById(userId: String): User? {
        return userDao.getUserById(userId)?.toDomain()
    }
    
    fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers().map { list -> list.map { it.toDomain() } }
    }
    
    suspend fun approveUser(userId: String) {
        userDao.approveUser(userId, System.currentTimeMillis())
    }
}