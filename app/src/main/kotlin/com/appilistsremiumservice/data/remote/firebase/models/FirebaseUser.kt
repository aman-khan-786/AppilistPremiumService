package com.appilistpremiumservice.data.remote.firebase.models

data class FirebaseUser(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val role: String = "",
    val shopId: String = "",
    val isApproved: Boolean = false,
    val createdAt: Long = 0L,
    val updatedAt: Long = 0L
) {
    // Firebase requires no-argument constructor
    constructor() : this("", "", "", "", "", false, 0L, 0L)
}