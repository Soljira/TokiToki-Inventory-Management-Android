package com.example.tokitokiinventorymanagementandroid.models.dataclasses

import com.google.firebase.Timestamp

// can be used to tracks multiple deliveries of the same item
// bundles are used instead of counting the inventory items per piece
data class InventoryBatch(
    val batchID: String = "",
    val batchPrice: Double = 0.0,     // calculated by getting the itemPrice from the itemID and multiplying it by the totalQuantity
    val itemID: String = "",          // foreign key linking to Product data class
    val bundleQuantity: Int = 0,      // Derived value: totalQuantity / bundleSize
    val bundleSize: Double = 0.0,     // in kg
    val totalQuantity: Double = 0.0,  // Derived value: bundleQuantity * bundleSize
    val dateDelivered: Timestamp? = null,
    val expiryDate: Timestamp? = null     // Different per batch!  IDK PANO TO I-INITIALIZE SO FOR NOW USE NULL BUT RESEARCH HOW TO INITIALIZE IT PROPERLY
)
