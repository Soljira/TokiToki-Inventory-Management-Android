package com.example.tokitokiinventorymanagementandroid.dataclasses
import com.google.firebase.firestore.FirebaseFirestore

import com.google.firebase.Timestamp

// Enum class for unit of measure
enum class UnitOfMeasure {
    GRAMS,
    KILOGRAMS,
    LITERS,
    MILLILITERS,
    PIECES,
    UNITS,
}

// Data class for inventory item
data class InventoryItem(
    val itemID: String = "",  // Unique ID for the inventory item
    val productName: String = "",  // Name of the product
    val supplier: String = "",  // Supplier name
    val supplierID: String = "",  // Supplier ID
    val quantity: Double = 0.0,  // Quantity in stock (can use Double)
    val unitOfMeasure: String = "",  // Unit of measure (from enum)
    val usedInRecipes: MutableList<Recipe> = mutableListOf(),  // Recipes where the item is used
    val expiryDate: Timestamp? = null  // Expiry date (null by default, can be set to Timestamp if needed)
)

// Sample usage of adding an item to Firebase Firestore
fun addInventoryItemToFirestore() {
    val db = FirebaseFirestore.getInstance()

    // Example Inventory Item
    val item = InventoryItem(
        itemID = "item11",
        productName = "Shrimp (Suahe)",
        supplier = "Supplier C",
        supplierID = "supplier123",
        quantity = 15.0,
        unitOfMeasure = UnitOfMeasure.PIECES.name,
        expiryDate = Timestamp.now()  // Use current time as expiry date (or provide specific date)
    )

    // Add the item to Firestore collection 'inventory'
    db.collection("inventory")
        .document(item.itemID)
        .set(item)  // Use the .set() method to add or overwrite the document
        .addOnSuccessListener {
            println("Item added successfully!")
        }
        .addOnFailureListener { e ->
            println("Error adding item: $e")
        }
}
