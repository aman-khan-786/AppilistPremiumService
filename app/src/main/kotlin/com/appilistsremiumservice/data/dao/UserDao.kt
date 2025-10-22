package com.appilistpremiumservice.data.local.dao

import androidx.room.*
import com.appilistpremiumservice.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * User Data Access Object
 * Database operations for User table
 */
@Dao
interface UserDao {
    
    /**
     * Insert new user
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)
    
    /**
     * Insert multiple users
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)
    
    /**
     * Update existing user
     */
    @Update
    suspend fun updateUser(user: UserEntity)
    
    /**
     * Delete user
     */
    @Delete
    suspend fun deleteUser(user: UserEntity)
    
    /**
     * Get user by ID
     */
    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: String): UserEntity?
    
    /**
     * Get user by email
     */
    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): UserEntity?
    
    /**
     * Get user by email and password (for login)
     */
    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    suspend fun login(email: String, password: String): UserEntity?
    
    /**
     * Get all users
     */
    @Query("SELECT * FROM users ORDER BY name ASC")
    fun getAllUsers(): Flow<List<UserEntity>>
    
    /**
     * Get all approved users
     */
    @Query("SELECT * FROM users WHERE isApproved = 1 ORDER BY name ASC")
    fun getApprovedUsers(): Flow<List<UserEntity>>
    
    /**
     * Get all pending users (waiting for approval)
     */
    @Query("SELECT * FROM users WHERE isApproved = 0 ORDER BY createdAt DESC")
    fun getPendingUsers(): Flow<List<UserEntity>>
    
    /**
     * Get users by role
     */
    @Query("SELECT * FROM users WHERE role = :role ORDER BY name ASC")
    fun getUsersByRole(role: String): Flow<List<UserEntity>>
    
    /**
     * Get users by shop ID
     */
    @Query("SELECT * FROM users WHERE shopId = :shopId ORDER BY name ASC")
    fun getUsersByShop(shopId: String): Flow<List<UserEntity>>
    
    /**
     * Approve user
     */
    @Query("UPDATE users SET isApproved = 1, updatedAt = :timestamp WHERE id = :userId")
    suspend fun approveUser(userId: String, timestamp: Long)
    
    /**
     * Check if email exists
     */
    @Query("SELECT COUNT(*) FROM users WHERE email = :email")
    suspend fun isEmailExists(email: String): Int
    
    /**
     * Delete all users
     */
    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()
}