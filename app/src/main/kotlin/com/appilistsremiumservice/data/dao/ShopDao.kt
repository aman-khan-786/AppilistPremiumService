package com.appilistpremiumservice.data.local.dao

import androidx.room.*
import com.appilistpremiumservice.data.local.entity.ShopEntity
import kotlinx.coroutines.flow.Flow

/**
 * Shop Data Access Object
 * Database operations for Shop table
 */
@Dao
interface ShopDao {
    
    /**
     * Insert new shop
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShop(shop: ShopEntity)
    
    /**
     * Insert multiple shops
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShops(shops: List<ShopEntity>)
    
    /**
     * Update existing shop
     */
    @Update
    suspend fun updateShop(shop: ShopEntity)
    
    /**
     * Delete shop
     */
    @Delete
    suspend fun deleteShop(shop: ShopEntity)
    
    /**
     * Get shop by ID
     */
    @Query("SELECT * FROM shops WHERE id = :shopId")
    suspend fun getShopById(shopId: String): ShopEntity?
    
    /**
     * Get all shops
     */
    @Query("SELECT * FROM shops ORDER BY name ASC")
    fun getAllShops(): Flow<List<ShopEntity>>
    
    /**
     * Get active shops only
     */
    @Query("SELECT * FROM shops WHERE isActive = 1 ORDER BY name ASC")
    fun getActiveShops(): Flow<List<ShopEntity>>
    
    /**
     * Get shops by type
     */
    @Query("SELECT * FROM shops WHERE type = :type ORDER BY name ASC")
    fun getShopsByType(type: String): Flow<List<ShopEntity>>
    
    /**
     * Toggle shop active status
     */
    @Query("UPDATE shops SET isActive = :isActive WHERE id = :shopId")
    suspend fun toggleShopStatus(shopId: String, isActive: Boolean)
    
    /**
     * Delete all shops
     */
    @Query("DELETE FROM shops")
    suspend fun deleteAllShops()
}