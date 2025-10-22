package com.appilistpremiumservice.data.remote.firebase.models

data class FirebaseStock(
    val id: String = "",
    val productName: String = "",
    val category: String = "",
    val quantity: Int = 0,
    val purchasePrice: Double = 0.0,
    val sellingPrice: Double = 0.0,
    val shopId: String = "",
    val lastUpdatedBy: String = "",
    val createdAt: Long = 0L,
    val updatedAt: Long = 0L
) {
    constructor() : this("", "", "", 0, 0.0, 0.0, "", "", 0L, 0L)
}