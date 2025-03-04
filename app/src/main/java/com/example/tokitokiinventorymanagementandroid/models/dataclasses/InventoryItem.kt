package com.example.tokitokiinventorymanagementandroid.models.dataclasses


/**
 *
 * Different from OrderedItem. InventoryItem is meant to track stock inside the inventory, not for orders.
 *
 * May duplicates pa rin to; different per supplier
 *
 * The manager should see the itemPrice update in real-time whenever the supplier updates it
 */
data class InventoryItem(
    val itemID: String = "",
    val productName: String = "",
    val supplierID: String = "",
    val itemPrice: Double = 0.0    // should be set by the supplier; subject to change!
)
