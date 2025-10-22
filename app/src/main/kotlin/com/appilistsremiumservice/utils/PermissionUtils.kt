package com.appilistpremiumservice.utils

import com.appilistpremiumservice.domain.model.UserRole

/**
 * Permission Management Utility
 * Check user access rights for features
 */
object PermissionUtils {
    
    // Permission Types
    enum class Permission {
        VIEW_DASHBOARD,
        VIEW_ALL_SHOPS_DATA,
        ADD_SALES,
        EDIT_SALES,
        DELETE_SALES,
        VIEW_SALES_HISTORY,
        ADD_STOCK,
        EDIT_STOCK,
        DELETE_STOCK,
        VIEW_STOCK,
        MARK_ATTENDANCE,
        VIEW_ATTENDANCE_REPORT,
        APPROVE_USERS,
        MANAGE_PERMISSIONS,
        VIEW_REPORTS,
        EXPORT_DATA
    }
    
    /**
     * Check if user has permission
     */
    fun hasPermission(userRole: UserRole, permission: Permission): Boolean {
        return when (userRole) {
            UserRole.ADMIN -> {
                // Admin has all permissions
                true
            }
            UserRole.STAFF -> {
                // Staff has limited permissions
                when (permission) {
                    Permission.ADD_SALES,
                    Permission.VIEW_SALES_HISTORY,
                    Permission.VIEW_STOCK,
                    Permission.MARK_ATTENDANCE -> true
                    else -> false
                }
            }
        }
    }
    
    /**
     * Get all permissions for a role
     */
    fun getPermissionsForRole(userRole: UserRole): List<Permission> {
        return Permission.values().filter { 
            hasPermission(userRole, it) 
        }
    }
    
    /**
     * Check if user can view dashboard
     */
    fun canViewDashboard(userRole: UserRole): Boolean {
        return hasPermission(userRole, Permission.VIEW_DASHBOARD)
    }
    
    /**
     * Check if user can manage stock
     */
    fun canManageStock(userRole: UserRole): Boolean {
        return hasPermission(userRole, Permission.ADD_STOCK) &&
                hasPermission(userRole, Permission.EDIT_STOCK)
    }
    
    /**
     * Check if user can approve other users
     */
    fun canApproveUsers(userRole: UserRole): Boolean {
        return hasPermission(userRole, Permission.APPROVE_USERS)
    }
    
    /**
     * Check if user can view all shops data
     */
    fun canViewAllShops(userRole: UserRole): Boolean {
        return hasPermission(userRole, Permission.VIEW_ALL_SHOPS_DATA)
    }
    
    /**
     * Check if user can export data
     */
    fun canExportData(userRole: UserRole): Boolean {
        return hasPermission(userRole, Permission.EXPORT_DATA)
    }
    
    /**
     * Get permission description
     */
    fun getPermissionDescription(permission: Permission): String {
        return when (permission) {
            Permission.VIEW_DASHBOARD -> "View Dashboard"
            Permission.VIEW_ALL_SHOPS_DATA -> "View All Shops Data"
            Permission.ADD_SALES -> "Add Sales Entry"
            Permission.EDIT_SALES -> "Edit Sales Entry"
            Permission.DELETE_SALES -> "Delete Sales Entry"
            Permission.VIEW_SALES_HISTORY -> "View Sales History"
            Permission.ADD_STOCK -> "Add Stock"
            Permission.EDIT_STOCK -> "Edit Stock"
            Permission.DELETE_STOCK -> "Delete Stock"
            Permission.VIEW_STOCK -> "View Stock"
            Permission.MARK_ATTENDANCE -> "Mark Attendance"
            Permission.VIEW_ATTENDANCE_REPORT -> "View Attendance Report"
            Permission.APPROVE_USERS -> "Approve New Users"
            Permission.MANAGE_PERMISSIONS -> "Manage User Permissions"
            Permission.VIEW_REPORTS -> "View Reports"
            Permission.EXPORT_DATA -> "Export Data"
        }
    }
}