package com.appilistpremiumservice.data.repository

import com.appilistpremiumservice.data.local.dao.ShopDao
import com.appilistpremiumservice.data.local.entity.ShopEntity
import com.appilistpremiumservice.data.local.entity.toDomain
import com.appilistpremiumservice.domain.model.Shop
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ShopRepository(private val shopDao: ShopDao) {
    
    suspend fun insertShop(shop: ShopEntity) = shopDao.insertShop(shop)
    
    fun getAllShops(): Flow<List<Shop>> {
        return shopDao.getAllShops().map { list -> list.map { it.toDomain() } }
    }
}