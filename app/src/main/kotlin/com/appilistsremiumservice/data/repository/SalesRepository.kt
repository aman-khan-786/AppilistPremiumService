package com.appilistpremiumservice.data.repository

import com.appilistpremiumservice.data.local.dao.SalesDao
import com.appilistpremiumservice.data.local.entity.SalesEntity
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.Sales
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SalesRepository(private val salesDao: SalesDao) {
    
    suspend fun insertSales(sales: SalesEntity) = salesDao.insertSales(sales)
    
    fun getAllSales(): Flow<List<Sales>> {
        return salesDao.getAllSales().map { list -> list.map { it.toDomain() } }
    }
    
    fun getSalesByDate(date: String): Flow<List<Sales>> {
        return salesDao.getSalesByDate(date).map { list -> list.map { it.toDomain() } }
    }
}