package com.appilistpremiumservice.ui.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appilistpremiumservice.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashboard(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Admin Dashboard") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = "Admin Controls",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
            
            item {
                AdminOptionCard(
                    title = "User Approvals",
                    icon = Icons.Default.PersonAdd,
                    onClick = { navController.navigate(Screen.UserApproval.route) }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
            
            item {
                AdminOptionCard(
                    title = "View All Reports",
                    icon = Icons.Default.Assessment,
                    onClick = { /* TODO */ }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
            
            item {
                AdminOptionCard(
                    title = "Manage Permissions",
                    icon = Icons.Default.Security,
                    onClick = { navController.navigate(Screen.Profile.route) }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
            
            item {
                AdminOptionCard(
                    title = "All Shops Data",
                    icon = Icons.Default.Store,
                    onClick = { /* TODO */ }
                )
            }
        }
    }
}

@Composable
fun AdminOptionCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Arrow"
            )
        }
    }
}