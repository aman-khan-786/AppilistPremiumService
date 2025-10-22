package com.appilistpremiumservice.domain.usecase.stock

import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.data.local.entity.toEntity
import com.appilistpremiumservice.domain.model.Stock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateStockUseCase(private val database: AppDatabase) {
    
    suspend operator fun invoke(stock: Stock): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                database.stockDao().updateStock(stock.toEntity())
                Result.success(Unit)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}