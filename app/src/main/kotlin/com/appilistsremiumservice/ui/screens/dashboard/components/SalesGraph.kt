package com.appilistpremiumservice.ui.screens.dashboard.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SalesGraph(
    data: List<Float>,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Sales Trend",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            if (data.isEmpty()) {
                Text("No data available")
            } else {
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    val maxValue = data.maxOrNull() ?: 1f
                    val barWidth = size.width / data.size
                    
                    data.forEachIndexed { index, value ->
                        val barHeight = (value / maxValue) * size.height
                        drawRect(
                            color = Color(0xFF1976D2),
                            topLeft = Offset(index * barWidth, size.height - barHeight),
                            size = androidx.compose.ui.geometry.Size(barWidth * 0.8f, barHeight)
                        )
                    }
                }
            }
        }
    }
}