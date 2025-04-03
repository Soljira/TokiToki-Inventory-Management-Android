package com.example.tokitokiinventorymanagementandroid.manager.orders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tokitokiinventorymanagementandroid.R
import com.example.tokitokiinventorymanagementandroid.dataclasses.InventoryItem
import java.text.NumberFormat
import java.util.Locale

class OrdersAdapter(
    private val ordersList: List<Order>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val orderId: TextView = itemView.findViewById(R.id.orderIdTextView)
        val supplier: TextView = itemView.findViewById(R.id.supplierTextView)
        val product: TextView = itemView.findViewById(R.id.productTextView)
        val total: TextView = itemView.findViewById(R.id.totalTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.order_item_layout, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = ordersList[position]
        holder.orderId.text = order.orderId

        // Display all the products in the order
        val productNames = order.items.values.joinToString(", ") { it.productName }
        holder.product.text = "Products: $productNames"

        // Display supplier(s) for the products
        val suppliers = order.items.values.map { it.supplier }.distinct().joinToString(", ")
        holder.supplier.text = "Supplier(s): $suppliers"

        // Format and display total price
        val formattedTotal = formatCurrency(order.totalPrice)
        holder.total.text = "Total: $formattedTotal"

        // Set click listener
        holder.itemView.setOnClickListener {
            onItemClick(order.orderId)
        }
    }

    override fun getItemCount(): Int = ordersList.size

    // Helper function to format the total price as currency
    private fun formatCurrency(amount: Double): String {
        val numberFormat = NumberFormat.getCurrencyInstance(Locale("en", "PH"))
        return numberFormat.format(amount)
    }
}
