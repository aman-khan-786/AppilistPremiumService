package com.appilistpremiumservice.ui.screens.stock

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStockScreen(navController: NavController) {
    var productName by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var purchasePrice by remember { mutableStateOf("") }
    var sellingPrice by remember { mutableStateOf("") }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Stock Item") },
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
            CustomTextField(
                value = productName,
                onValueChange = { productName = it },
                label = "Product Name",
                placeholder = "Enter product name"
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = category,
                onValueChange = { category = it },
                label = "Category",
                placeholder = "e.g., Back Cover"
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = quantity,
                onValueChange = { quantity = it },
                label = "Quantity",
                placeholder = "0",
                keyboardType = KeyboardType.Number
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = purchasePrice,
                onValueChange = { purchasePrice = it },
                label = "Purchase Price",
                placeholder = "0.00",
                keyboardType = KeyboardType.Decimal
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            CustomTextField(
                value = sellingPrice,
                onValueChange = { sellingPrice = it },
                label = "Selling Price",
                placeholder = "0.00",
                keyboardType = KeyboardType.Decimal
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            CustomButton(
                text = "Add Stock",
                onClick = {
                    // TODO: Save to database
                    navController.popBackStack()
                }
            )
        }
    }
}