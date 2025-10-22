package com.appilistpremiumservice.domain.model

/**
 * Stock Domain Model
 * Inventory item
 */
data class Stock(
    val id: String = "",
    val productName: String = "",
    val category: StockCategory = StockCategory.BACK_COVER,
    val quantity: Int = 0,
    val purchasePrice: Double = 0.0,
    val sellingPrice: Double = 0.0,
    val shopId: String = "",
    val lastUpdatedBy: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    /**
     * Check if stock is low
     */
    fun isLowStock(): Boolean {
        return quantity <= 10
    }
    
    /**
     * Check if out of stock
     */
    fun isOutOfStock(): Boolean {
        return quantity == 0
    }
    
    /**
     * Calculate profit margin
     */
    fun getProfitMargin(): Double {
        return if (purchasePrice > 0) {
            ((sellingPrice - purchasePrice) / purchasePrice) * 100
        } else 0.0
    }
    
    /**
     * Get profit per unit
     */
    fun getProfitPerUnit(): Double {
        return sellingPrice - purchasePrice
    }
    
    /**
     * Get total value of stock
     */
    fun getTotalValue(): Double {
        return quantity * sellingPrice
    }
    
    /**
     * Get category display name
     */
    fun getCategoryName(): String {
        return category.displayName
    }
}

/**
 * Stock Category Enum
 */
enum class StockCategory(val displayName: String) {
    BACK_COVER("Back Cover"),
    TEMPER_GLASS("Tempered Glass"),
    CHARGER("Charger"),
    CABLE("Cable"),
    EARPHONE("Earphone"),
    POWER_BANK("Power Bank"),
    MOBILE_HOLDER("Mobile Holder"),
    SCREEN_GUARD("Screen Guard"),
    OTHER("Other");
    
    companion object {
        fun fromString(category: String): StockCategory {
            return values().find { 
                it.name.equals(category, ignoreCase = true) 
            } ?: OTHER
        }
        
        fun getAllCategories(): List<String> {
            return values().map { it.displayName }
        }
    }
}