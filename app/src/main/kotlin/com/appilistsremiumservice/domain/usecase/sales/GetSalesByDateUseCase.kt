package com.appilistpremiumservice.domain.usecase.sales

import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.Sales
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Get Sales by Date Use Case
 */
class GetSalesByDateUseCase(private val database: AppDatabase) {
    
    operator fun invoke(date: String): Flow<List<Sales>> {
        return database.salesDao().getSalesByDate(date).map { list ->
            list.map { it.toDomain() }
        }
    }
}