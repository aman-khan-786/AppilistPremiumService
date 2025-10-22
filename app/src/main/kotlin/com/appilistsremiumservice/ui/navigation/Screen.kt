package com.appilistpremiumservice.ui.navigation

/**
 * Navigation Routes
 * Sealed class for type-safe navigation
 */
sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Signup : Screen("signup")
    object Dashboard : Screen("dashboard")
    object SalesEntry : Screen("sales_entry")
    object SalesHistory : Screen("sales_history")
    object StockList : Screen("stock_list")
    object AddStock : Screen("add_stock")
    object EditStock : Screen("edit_stock/{stockId}") {
        fun createRoute(stockId: String) = "edit_stock/$stockId"
    }
    object Attendance : Screen("attendance")
    object AttendanceReport : Screen("attendance_report")
    object AdminDashboard : Screen("admin_dashboard")
    object UserApproval : Screen("user_approval")
    object Profile : Screen("profile")
}