package com.appilistpremiumservice.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.appilistpremiumservice.domain.model.Stock
import com.appilistpremiumservice.domain.model.StockCategory

/**
 * Stock Table Entity
 * Room database table for inventory
 */
@Entity(tableName = "stock")
data class StockEntity(
    @PrimaryKey
    val id: String,
    val productName: String,
    val category: String,
    val quantity: Int,
    val purchasePrice: Double,
    val sellingPrice: Double,
    val shopId: String,
    val lastUpdatedBy: String,
    val createdAt: Long,
    val updatedAt: Long
)

/**
 * Convert Entity to Domain Model
 */
fun StockEntity.toDomain(): Stock {
    return Stock(
        id = id,
        productName = productName,
        category = StockCategory.fromString(category),
        quantity = quantity,
        purchasePrice = purchasePrice,
        sellingPrice = sellingPrice,
        shopId = shopId,
        lastUpdatedBy = lastUpdatedBy,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

/**
 * Convert Domain Model to Entity
 */
fun Stock.toEntity(): StockEntity {
    return StockEntity(
        id = id,
        productName = productName,
        category = category.name,
        quantity = quantity,
        purchasePrice = purchasePrice,
        sellingPrice = sellingPrice,
        shopId = shopId,
        lastUpdatedBy = lastUpdatedBy,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}