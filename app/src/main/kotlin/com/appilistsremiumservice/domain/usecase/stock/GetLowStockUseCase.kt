package com.appilistpremiumservice.domain.usecase.stock

import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.Stock
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Get Low Stock Items Use Case
 */
class GetLowStockUseCase(private val database: AppDatabase) {
    
    operator fun invoke(): Flow<List<Stock>> {
        return database.stockDao().getLowStock().map { list ->
            list.map { it.toDomain() }
        }
    }
}