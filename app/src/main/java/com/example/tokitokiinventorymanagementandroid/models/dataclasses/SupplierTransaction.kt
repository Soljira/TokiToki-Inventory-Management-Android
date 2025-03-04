package com.example.tokitokiinventorymanagementandroid.models.dataclasses

import com.example.tokitokiinventorymanagementandroid.models.enums.TransactionStatus
import com.google.firebase.Timestamp


data class SupplierTransaction(
    val transactionID: String = "",
    val branchID: String = "",
    val dateTimeOrdered: Timestamp? = null,
    val expectedArrival: Timestamp? = null,
    val actualArrival: Timestamp? = null,
    val items: List<OrderedItem> = listOf(),
    val managers: List<String> = listOf(),
    val supplierID: String = "",
    val status: TransactionStatus = TransactionStatus.PENDING,  // Pending, Delivered, Canceled
    val totalCost: Double = 0.0 // total of all subtotal fields in items
)