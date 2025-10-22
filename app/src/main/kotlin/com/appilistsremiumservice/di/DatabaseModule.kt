package com.appilistpremiumservice.di

import android.content.Context
import com.appilistpremiumservice.data.local.AppDatabase

object DatabaseModule {
    
    fun provideDatabase(context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }
    
    fun provideUserDao(database: AppDatabase) = database.userDao()
    
    fun provideShopDao(database: AppDatabase) = database.shopDao()
    
    fun provideSalesDao(database: AppDatabase) = database.salesDao()
    
    fun provideStockDao(database: AppDatabase) = database.stockDao()
    
    fun provideAttendanceDao(database: AppDatabase) = database.attendanceDao()
}