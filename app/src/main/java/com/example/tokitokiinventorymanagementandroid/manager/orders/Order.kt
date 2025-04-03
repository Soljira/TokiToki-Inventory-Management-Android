package com.example.tokitokiinventorymanagementandroid.manager.orders

data class Order(
    val id: String = "",
    val customerName: String = "",
    val orderDate: String = "",
    val totalAmount: Double = 0.0
)
