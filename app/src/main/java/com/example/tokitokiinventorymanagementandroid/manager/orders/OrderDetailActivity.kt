package com.example.tokitokiinventorymanagementandroid.manager.orders

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tokitokiinventorymanagementandroid.R

class OrderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        // Get the orderId passed in the intent
        val orderId = intent.getStringExtra("ORDER_ID")

        // Use the orderId to fetch the order details from Firestore or use it as needed
        // You can display the details in the UI (e.g., in a TextView, RecyclerView, etc.)
    }
}
