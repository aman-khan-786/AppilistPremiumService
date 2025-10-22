package com.appilistpremiumservice.ui.screens.sales

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appilistpremiumservice.ui.components.CustomButton
import com.appilistpremiumservice.ui.components.CustomTextField
import com.appilistpremiumservice.utils.DateUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalesEntryScreen(navController: NavController) {
    var totalSales by remember { mutableStateOf("") }
    var cashAmount by remember { mutableStateOf("") }
    var onlineAmount by remember { mutableStateOf("") }
    var customersServed by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    var showSuccess by remember { mutableStateOf(false) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Sales Entry") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Date: ${DateUtils.getCurrentDate()}",
                style = MaterialTheme.typography.titleMedium
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            CustomTextField(
                value = totalSales,
                onValueChange = { totalSales = it },
                label = "Total Sales",
                placeholder = "0.00",
                keyboardType = KeyboardType.Decimal
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = cashAmount,
                onValueChange = { cashAmount = it },
                label = "Cash Amount",
                placeholder = "0.00",
                keyboardType = KeyboardType.Decimal
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = onlineAmount,
                onValueChange = { onlineAmount = it },
                label = "Online Amount",
                placeholder = "0.00",
                keyboardType = KeyboardType.Decimal
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = customersServed,
                onValueChange = { customersServed = it },
                label = "Customers Served",
                placeholder = "0",
                keyboardType = KeyboardType.Number
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = notes,
                onValueChange = { notes = it },
                label = "Notes (Optional)",
                placeholder = "Add any notes",
                singleLine = false,
                maxLines = 3
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            CustomButton(
                text = "Submit Sales",
                onClick = {
                    // TODO: Save to database
                    showSuccess = true
                }
            )
            
            if (showSuccess) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Sales entry saved successfully!",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}