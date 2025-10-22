package com.appilistpremiumservice.domain.usecase.stock

import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.Stock
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetStockUseCase(private val database: AppDatabase) {
    
    operator fun invoke(): Flow<List<Stock>> {
        return database.stockDao().getAllStock().map { list ->
            list.map { it.toDomain() }
        }
    }
}