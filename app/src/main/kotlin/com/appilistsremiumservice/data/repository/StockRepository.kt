package com.appilistpremiumservice.data.repository

import com.appilistpremiumservice.data.local.dao.StockDao
import com.appilistpremiumservice.data.local.entity.StockEntity
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.Stock
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StockRepository(private val stockDao: StockDao) {
    
    suspend fun insertStock(stock: StockEntity) = stockDao.insertStock(stock)
    
    fun getAllStock(): Flow<List<Stock>> {
        return stockDao.getAllStock().map { list -> list.map { it.toDomain() } }
    }
    
    fun getLowStock(): Flow<List<Stock>> {
        return stockDao.getLowStock().map { list -> list.map { it.toDomain() } }
    }
}