package com.appilistpremiumservice.domain.model

/**
 * Shop Domain Model
 * Represents a retail shop/store
 */
data class Shop(
    val id: String = "",
    val name: String = "",
    val type: ShopType = ShopType.MOBILE_ACCESSORIES,
    val address: String = "",
    val phone: String = "",
    val isActive: Boolean = true,
    val createdAt: Long = System.currentTimeMillis()
) {
    /**
     * Get shop type display name
     */
    fun getTypeDisplayName(): String {
        return when (type) {
            ShopType.MOBILE_ACCESSORIES -> "Mobile Accessories"
            ShopType.REPAIR_CENTER -> "Repair Center"
            ShopType.OTHER -> "Other"
        }
    }
}

/**
 * Shop Type Enum
 */
enum class ShopType {
    MOBILE_ACCESSORIES,
    REPAIR_CENTER,
    OTHER;
    
    companion object {
        fun fromString(type: String): ShopType {
            return when (type.uppercase()) {
                "MOBILE_ACCESSORIES" -> MOBILE_ACCESSORIES
                "REPAIR_CENTER" -> REPAIR_CENTER
                else -> OTHER
            }
        }
    }
}