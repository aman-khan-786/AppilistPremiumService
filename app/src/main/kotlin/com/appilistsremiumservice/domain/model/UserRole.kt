package com.appilistpremiumservice.domain.model

/**
 * User Role Enum
 * Defines access levels
 */
enum class UserRole {
    ADMIN,    // Full access to all features
    STAFF;    // Limited access
    
    companion object {
        /**
         * Convert string to UserRole
         */
        fun fromString(role: String): UserRole {
            return when (role.uppercase()) {
                "ADMIN" -> ADMIN
                "STAFF" -> STAFF
                else -> STAFF // Default to STAFF
            }
        }
    }
    
    /**
     * Check if user is admin
     */
    fun isAdmin(): Boolean = this == ADMIN
    
    /**
     * Check if user is staff
     */
    fun isStaff(): Boolean = this == STAFF
}