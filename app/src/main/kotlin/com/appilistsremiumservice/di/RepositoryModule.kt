package com.appilistpremiumservice.di

import com.appilistpremiumservice.data.local.AppDatabase
import com.appilistpremiumservice.data.repository.*

object RepositoryModule {
    
    fun provideUserRepository(database: AppDatabase): UserRepository {
        return UserRepository(database.userDao())
    }
    
    fun provideSalesRepository(database: AppDatabase): SalesRepository {
        return SalesRepository(database.salesDao())
    }
    
    fun provideStockRepository(database: AppDatabase): StockRepository {
        return StockRepository(database.stockDao())
    }
    
    fun provideAttendanceRepository(database: AppDatabase): AttendanceRepository {
        return AttendanceRepository(database.attendanceDao())
    }
    
    fun provideShopRepository(database: AppDatabase): ShopRepository {
        return ShopRepository(database.shopDao())
    }
}