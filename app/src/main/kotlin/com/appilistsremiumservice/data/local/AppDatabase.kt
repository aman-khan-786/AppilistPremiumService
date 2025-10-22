package com.appilistpremiumservice.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appilistpremiumservice.data.local.dao.*
import com.appilistpremiumservice.data.local.entity.*

/**
 * Room Database - Schema Export Disabled for AndroidIDE compatibility
 */
@Database(
    entities = [
        UserEntity::class,
        ShopEntity::class,
        SalesEntity::class,
        StockEntity::class,
        AttendanceEntity::class
    ],
    version = 1,
    exportSchema = false  // IMPORTANT: Disabled for mobile IDE
)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun userDao(): UserDao
    abstract fun shopDao(): ShopDao
    abstract fun salesDao(): SalesDao
    abstract fun stockDao(): StockDao
    abstract fun attendanceDao(): AttendanceDao
    
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        
        private const val DATABASE_NAME = "appilist_database"
        
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                
                INSTANCE = instance
                instance
            }
        }
        
        fun clearInstance() {
            INSTANCE = null
        }
    }
}