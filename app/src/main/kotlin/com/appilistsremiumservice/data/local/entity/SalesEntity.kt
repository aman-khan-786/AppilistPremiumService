package com.appilistpremiumservice.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.appilistpremiumservice.domain.model.Sales

/**
 * Sales Table Entity
 * Room database table for daily sales
 */
@Entity(tableName = "sales")
data class SalesEntity(
    @PrimaryKey
    val id: String,
    val date: String,
    val shopId: String,
    val staffId: String,
    val totalSales: Double,
    val cashAmount: Double,
    val onlineAmount: Double,
    val customersServed: Int,
    val notes: String,
    val createdAt: Long,
    val updatedAt: Long
)

/**
 * Convert Entity to Domain Model
 */
fun SalesEntity.toDomain(): Sales {
    return Sales(
        id = id,
        date = date,
        shopId = shopId,
        staffId = staffId,
        totalSales = totalSales,
        cashAmount = cashAmount,
        onlineAmount = onlineAmount,
        customersServed = customersServed,
        notes = notes,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

/**
 * Convert Domain Model to Entity
 */
fun Sales.toEntity(): SalesEntity {
    return SalesEntity(
        id = id,
        date = date,
        shopId = shopId,
        staffId = staffId,
        totalSales = totalSales,
        cashAmount = cashAmount,
        onlineAmount = onlineAmount,
        customersServed = customersServed,
        notes = notes,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}