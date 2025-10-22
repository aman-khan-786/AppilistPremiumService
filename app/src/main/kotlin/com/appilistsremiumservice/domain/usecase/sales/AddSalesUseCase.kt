package com.appilistpremiumservice.domain.usecase.sales

import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.data.local.entity.toEntity
import com.appilistpremiumservice.domain.model.Sales
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

/**
 * Add Sales Use Case
 * Add new sales entry
 */
class AddSalesUseCase(private val database: AppDatabase) {
    
    suspend operator fun invoke(sales: Sales): Result<Unit> {
        return withContext(Dispatchers.IO) {
            try {
                val salesWithId = if (sales.id.isEmpty()) {
                    sales.copy(id = UUID.randomUUID().toString())
                } else sales
                
                database.salesDao().insertSales(salesWithId.toEntity())
                Result.success(Unit)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}