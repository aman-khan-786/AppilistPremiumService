package com.appilistpremiumservice.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appilistpremiumservice.ui.screens.splash.SplashScreen
import com.appilistpremiumservice.ui.screens.auth.*
import com.appilistpremiumservice.ui.screens.dashboard.DashboardScreen
import com.appilistpremiumservice.ui.screens.sales.*
import com.appilistpremiumservice.ui.screens.stock.*
import com.appilistpremiumservice.ui.screens.attendance.*
import com.appilistpremiumservice.ui.screens.admin.*
import com.appilistpremiumservice.ui.screens.profile.ProfileScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Splash.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Splash Screen
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        
        // Auth Screens
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        
        composable(Screen.Signup.route) {
            SignupScreen(navController = navController)
        }
        
        // Dashboard
        composable(Screen.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        
        // Sales Screens
        composable(Screen.SalesEntry.route) {
            SalesEntryScreen(navController = navController)
        }
        
        composable(Screen.SalesHistory.route) {
            SalesHistoryScreen(navController = navController)
        }
        
        // Stock Screens
        composable(Screen.StockList.route) {
            StockListScreen(navController = navController)
        }
        
        composable(Screen.AddStock.route) {
            AddStockScreen(navController = navController)
        }
        
        // Attendance Screens
        composable(Screen.Attendance.route) {
            AttendanceScreen(navController = navController)
        }
        
        composable(Screen.AttendanceReport.route) {
            AttendanceReportScreen(navController = navController)
        }
        
        // Admin Screens
        composable(Screen.AdminDashboard.route) {
            AdminDashboard(navController = navController)
        }
        
        composable(Screen.UserApproval.route) {
            UserApprovalScreen(navController = navController)
        }
        
        // Profile Screen
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}