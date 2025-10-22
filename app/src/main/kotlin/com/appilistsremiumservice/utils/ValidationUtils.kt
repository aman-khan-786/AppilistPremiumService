package com.appilistpremiumservice.utils

import android.util.Patterns

/**
 * Input Validation Utility
 * Email, password, phone number validation
 */
object ValidationUtils {
    
    /**
     * Validate email format
     * @param email String email to validate
     * @return Boolean true if valid
     */
    fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    
    /**
     * Validate password strength
     * Must be at least 6 characters
     */
    fun isValidPassword(password: String): Boolean {
        return password.length >= Constants.MIN_PASSWORD_LENGTH
    }
    
    /**
     * Check if password is strong
     * Contains uppercase, lowercase, digit, special char
     */
    fun isStrongPassword(password: String): Boolean {
        if (password.length < Constants.MIN_PASSWORD_LENGTH) return false
        
        val hasUpperCase = password.any { it.isUpperCase() }
        val hasLowerCase = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecialChar = password.any { !it.isLetterOrDigit() }
        
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar
    }
    
    /**
     * Validate username
     * Must be at least 3 characters
     */
    fun isValidUsername(username: String): Boolean {
        return username.length >= Constants.MIN_USERNAME_LENGTH
    }
    
    /**
     * Validate phone number (Indian format)
     * 10 digits starting with 6-9
     */
    fun isValidPhoneNumber(phone: String): Boolean {
        val phonePattern = "^[6-9]\\d{9}$"
        return phone.matches(phonePattern.toRegex())
    }
    
    /**
     * Validate amount (positive number)
     */
    fun isValidAmount(amount: String): Boolean {
        return try {
            val value = amount.toDouble()
            value > 0
        } catch (e: Exception) {
            false
        }
    }
    
    /**
     * Validate quantity (positive integer)
     */
    fun isValidQuantity(quantity: String): Boolean {
        return try {
            val value = quantity.toInt()
            value > 0
        } catch (e: Exception) {
            false
        }
    }
    
    /**
     * Check if string is empty or blank
     */
    fun isEmpty(text: String): Boolean {
        return text.trim().isEmpty()
    }
    
    /**
     * Check if all strings are not empty
     */
    fun areFieldsValid(vararg fields: String): Boolean {
        return fields.all { it.trim().isNotEmpty() }
    }
    
    /**
     * Get password strength level
     * @return 0 (weak), 1 (medium), 2 (strong)
     */
    fun getPasswordStrength(password: String): Int {
        var strength = 0
        
        if (password.length >= 8) strength++
        if (password.any { it.isUpperCase() }) strength++
        if (password.any { it.isDigit() }) strength++
        if (password.any { !it.isLetterOrDigit() }) strength++
        
        return when {
            strength <= 1 -> 0 // Weak
            strength <= 2 -> 1 // Medium
            else -> 2 // Strong
        }
    }
    
    /**
     * Sanitize input text (remove leading/trailing spaces)
     */
    fun sanitize(text: String): String {
        return text.trim()
    }
}