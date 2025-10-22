package com.appilistpremiumservice.data.local.dao

import androidx.room.*
import com.appilistpremiumservice.data.local.entity.SalesEntity
import kotlinx.coroutines.flow.Flow

/**
 * Sales Data Access Object
 * Database operations for Sales table
 */
@Dao
interface SalesDao {
    
    /**
     * Insert new sales entry
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSales(sales: SalesEntity)
    
    /**
     * Insert multiple sales entries
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSalesList(salesList: List<SalesEntity>)
    
    /**
     * Update existing sales entry
     */
    @Update
    suspend fun updateSales(sales: SalesEntity)
    
    /**
     * Delete sales entry
     */
    @Delete
    suspend fun deleteSales(sales: SalesEntity)
    
    /**
     * Get sales by ID
     */
    @Query("SELECT * FROM sales WHERE id = :salesId")
    suspend fun getSalesById(salesId: String): SalesEntity?
    
    /**
     * Get all sales entries
     */
    @Query("SELECT * FROM sales ORDER BY date DESC, createdAt DESC")
    fun getAllSales(): Flow<List<SalesEntity>>
    
    /**
     * Get sales by date
     */
    @Query("SELECT * FROM sales WHERE date = :date ORDER BY createdAt DESC")
    fun getSalesByDate(date: String): Flow<List<SalesEntity>>
    
    /**
     * Get sales by date range
     */
    @Query("SELECT * FROM sales WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getSalesByDateRange(startDate: String, endDate: String): Flow<List<SalesEntity>>
    
    /**
     * Get sales by shop ID
     */
    @Query("SELECT * FROM sales WHERE shopId = :shopId ORDER BY date DESC")
    fun getSalesByShop(shopId: String): Flow<List<SalesEntity>>
    
    /**
     * Get sales by shop ID and date range
     */
    @Query("SELECT * FROM sales WHERE shopId = :shopId AND date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getSalesByShopAndDateRange(shopId: String, startDate: String, endDate: String): Flow<List<SalesEntity>>
    
    /**
     * Get sales by staff ID
     */
    @Query("SELECT * FROM sales WHERE staffId = :staffId ORDER BY date DESC")
    fun getSalesByStaff(staffId: String): Flow<List<SalesEntity>>
    
    /**
     * Get total sales amount for a shop
     */
    @Query("SELECT SUM(totalSales) FROM sales WHERE shopId = :shopId")
    suspend fun getTotalSalesByShop(shopId: String): Double?
    
    /**
     * Get total sales amount for a date range
     */
    @Query("SELECT SUM(totalSales) FROM sales WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getTotalSalesByDateRange(startDate: String, endDate: String): Double?
    
    /**
     * Get total sales amount for shop and date range
     */
    @Query("SELECT SUM(totalSales) FROM sales WHERE shopId = :shopId AND date BETWEEN :startDate AND :endDate")
    suspend fun getTotalSalesByShopAndDateRange(shopId: String, startDate: String, endDate: String): Double?
    
    /**
     * Delete all sales
     */
    @Query("DELETE FROM sales")
    suspend fun deleteAllSales()
}