package com.appilistpremiumservice.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.appilistpremiumservice.domain.model.Shop
import com.appilistpremiumservice.domain.model.ShopType

/**
 * Shop Table Entity
 * Room database table for shops
 */
@Entity(tableName = "shops")
data class ShopEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val type: String,
    val address: String,
    val phone: String,
    val isActive: Boolean,
    val createdAt: Long
)

/**
 * Convert Entity to Domain Model
 */
fun ShopEntity.toDomain(): Shop {
    return Shop(
        id = id,
        name = name,
        type = ShopType.fromString(type),
        address = address,
        phone = phone,
        isActive = isActive,
        createdAt = createdAt
    )
}

/**
 * Convert Domain Model to Entity
 */
fun Shop.toEntity(): ShopEntity {
    return ShopEntity(
        id = id,
        name = name,
        type = type.name,
        address = address,
        phone = phone,
        isActive = isActive,
        createdAt = createdAt
    )
}