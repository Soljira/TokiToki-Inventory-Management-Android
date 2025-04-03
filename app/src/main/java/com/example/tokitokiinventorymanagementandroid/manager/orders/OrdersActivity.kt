package com.example.tokitokiinventorymanagementandroid.manager.orders
import com.example.tokitokiinventorymanagementandroid.manager.orders.Order

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tokitokiinventorymanagementandroid.R
import com.example.tokitokiinventorymanagementandroid.helpers.BottomNavigationInitialization
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore

class OrdersActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: OrdersAdapter
    private lateinit var emptyView: TextView
    private val ordersList = mutableListOf<Order>()
    private val db = FirebaseFirestore.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manager_orders_customer_orders)

        recyclerView = findViewById(R.id.ordersRecyclerView)
        emptyView = findViewById(R.id.emptyOrdersTextView)

        adapter = OrdersAdapter(ordersList) { order ->
            val intent = Intent(this, OrderDetailActivity::class.java)
            intent.putExtra("orderId", order.id)
            startActivity(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        loadOrders()
    }

    private fun loadOrders() {
        val ordersCollection = db.collection("orders")

        ordersCollection.get()
            .addOnSuccessListener { documents ->
                ordersList.clear()
                for (document in documents) {
                    val order = document.toObject(Order::class.java)
                    ordersList.add(order)
                }
                if (ordersList.isEmpty()) {
                    emptyView.visibility = View.VISIBLE
                } else {
                    emptyView.visibility = View.GONE
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.e("Firestore", "Error getting documents", exception)
            }
    }
}






