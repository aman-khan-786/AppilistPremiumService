package com.appilistpremiumservice.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.appilistpremiumservice.domain.model.User
import com.appilistpremiumservice.domain.model.UserRole

/**
 * User Table Entity
 * Room database table for users
 */
@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val role: String,
    val shopId: String,
    val isApproved: Boolean,
    val createdAt: Long,
    val updatedAt: Long
)

/**
 * Convert Entity to Domain Model
 */
fun UserEntity.toDomain(): User {
    return User(
        id = id,
        name = name,
        email = email,
        password = password,
        role = UserRole.fromString(role),
        shopId = shopId,
        isApproved = isApproved,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

/**
 * Convert Domain Model to Entity
 */
fun User.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        name = name,
        email = email,
        password = password,
        role = role.name,
        shopId = shopId,
        isApproved = isApproved,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}