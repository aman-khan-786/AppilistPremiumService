package com.appilistpremiumservice.domain.model

/**
 * User Domain Model
 * Business logic representation of User
 */
data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val role: UserRole = UserRole.STAFF,
    val shopId: String = "",
    val isApproved: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    /**
     * Check if user is admin
     */
    fun isAdmin(): Boolean = role == UserRole.ADMIN
    
    /**
     * Check if user is staff
     */
    fun isStaff(): Boolean = role == UserRole.STAFF
    
    /**
     * Check if user account is approved
     */
    fun isAccountActive(): Boolean = isApproved
    
    /**
     * Get display name (capitalize first letter)
     */
    fun getDisplayName(): String {
        return name.replaceFirstChar { it.uppercase() }
    }
}