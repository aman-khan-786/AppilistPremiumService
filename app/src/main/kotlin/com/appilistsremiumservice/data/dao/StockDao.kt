package com.appilistpremiumservice.data.local.dao

import androidx.room.*
import com.appilistpremiumservice.data.local.entity.StockEntity
import kotlinx.coroutines.flow.Flow

/**
 * Stock Data Access Object
 * Database operations for Stock table
 */
@Dao
interface StockDao {
    
    /**
     * Insert new stock item
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStock(stock: StockEntity)
    
    /**
     * Insert multiple stock items
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStockList(stockList: List<StockEntity>)
    
    /**
     * Update existing stock item
     */
    @Update
    suspend fun updateStock(stock: StockEntity)
    
    /**
     * Delete stock item
     */
    @Delete
    suspend fun deleteStock(stock: StockEntity)
    
    /**
     * Get stock by ID
     */
    @Query("SELECT * FROM stock WHERE id = :stockId")
    suspend fun getStockById(stockId: String): StockEntity?
    
    /**
     * Get all stock items
     */
    @Query("SELECT * FROM stock ORDER BY productName ASC")
    fun getAllStock(): Flow<List<StockEntity>>
    
    /**
     * Get stock by shop ID
     */
    @Query("SELECT * FROM stock WHERE shopId = :shopId ORDER BY productName ASC")
    fun getStockByShop(shopId: String): Flow<List<StockEntity>>
    
    /**
     * Get stock by category
     */
    @Query("SELECT * FROM stock WHERE category = :category ORDER BY productName ASC")
    fun getStockByCategory(category: String): Flow<List<StockEntity>>
    
    /**
     * Get stock by shop and category
     */
    @Query("SELECT * FROM stock WHERE shopId = :shopId AND category = :category ORDER BY productName ASC")
    fun getStockByShopAndCategory(shopId: String, category: String): Flow<List<StockEntity>>
    
    /**
     * Search stock by product name
     */
    @Query("SELECT * FROM stock WHERE productName LIKE '%' || :searchQuery || '%' ORDER BY productName ASC")
    fun searchStock(searchQuery: String): Flow<List<StockEntity>>
    
    /**
     * Get low stock items (quantity <= 10)
     */
    @Query("SELECT * FROM stock WHERE quantity <= 10 ORDER BY quantity ASC")
    fun getLowStock(): Flow<List<StockEntity>>
    
    /**
     * Get low stock items by shop
     */
    @Query("SELECT * FROM stock WHERE shopId = :shopId AND quantity <= 10 ORDER BY quantity ASC")
    fun getLowStockByShop(shopId: String): Flow<List<StockEntity>>
    
    /**
     * Get out of stock items
     */
    @Query("SELECT * FROM stock WHERE quantity = 0 ORDER BY productName ASC")
    fun getOutOfStock(): Flow<List<StockEntity>>
    
    /**
     * Update stock quantity
     */
    @Query("UPDATE stock SET quantity = :quantity, updatedAt = :timestamp WHERE id = :stockId")
    suspend fun updateStockQuantity(stockId: String, quantity: Int, timestamp: Long)
    
    /**
     * Delete all stock
     */
    @Query("DELETE FROM stock")
    suspend fun deleteAllStock()
}