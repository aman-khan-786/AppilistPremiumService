package com.appilistpremiumservice.domain.model

/**
 * Sales Domain Model
 * Daily sales entry
 */
data class Sales(
    val id: String = "",
    val date: String = "",
    val shopId: String = "",
    val staffId: String = "",
    val totalSales: Double = 0.0,
    val cashAmount: Double = 0.0,
    val onlineAmount: Double = 0.0,
    val customersServed: Int = 0,
    val notes: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    /**
     * Calculate total amount (cash + online)
     */
    fun calculateTotal(): Double {
        return cashAmount + onlineAmount
    }
    
    /**
     * Verify if amounts match
     */
    fun isAmountValid(): Boolean {
        return totalSales == (cashAmount + onlineAmount)
    }
    
    /**
     * Get formatted total sales
     */
    fun getFormattedTotal(): String {
        return "₹${String.format("%.2f", totalSales)}"
    }
    
    /**
     * Get cash percentage
     */
    fun getCashPercentage(): Int {
        return if (totalSales > 0) {
            ((cashAmount / totalSales) * 100).toInt()
        } else 0
    }
    
    /**
     * Get online percentage
     */
    fun getOnlinePercentage(): Int {
        return if (totalSales > 0) {
            ((onlineAmount / totalSales) * 100).toInt()
        } else 0
    }
}