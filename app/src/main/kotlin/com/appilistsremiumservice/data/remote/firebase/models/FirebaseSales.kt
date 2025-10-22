package com.appilistpremiumservice.data.remote.firebase.models

data class FirebaseSales(
    val id: String = "",
    val date: String = "",
    val shopId: String = "",
    val staffId: String = "",
    val totalSales: Double = 0.0,
    val cashAmount: Double = 0.0,
    val onlineAmount: Double = 0.0,
    val customersServed: Int = 0,
    val notes: String = "",
    val createdAt: Long = 0L,
    val updatedAt: Long = 0L
) {
    constructor() : this("", "", "", "", 0.0, 0.0, 0.0, 0, "", 0L, 0L)
}