package com.example.tokitokiinventorymanagementandroid.models.dataclasses

/**
 * Represents items being ordered (not stock in inventory).
 * Different from InventoryItem. OrderedItem is meant to track stock inside the inventory, not for orders.
 * Used in SupplierTransactions.
 */
data class OrderedItem(
    val itemID: String = "",
    val productName: String = "",
    val bundleQuantity: Int = 0,
    val bundleSize: Double = 0.0, // in kg
    val totalQuantity: Double = 0.0,  // bundleQuantity * bundleSize
    val pricePerBundle: Double = 0.0,
    val subtotal: Double = 0.0  // bundleQuantity * pricePerBundle
)
