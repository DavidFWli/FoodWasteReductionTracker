package com.example.foodwastereductiontracker

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater

class FoodAdapter(private val foodItems: List<FoodItem>) :
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodImage: ImageView = view.findViewById(R.id.food_image)
        val foodName: TextView = view.findViewById(R.id.food_name)
        val expiryDate: TextView = view.findViewById(R.id.expiry_date)
        val quantity: TextView = view.findViewById(R.id.quantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodItem = foodItems[position]
        holder.foodName.text = foodItem.name
        holder.expiryDate.text = "Expires on: ${foodItem.expiryDate}"
        holder.quantity.text = "Quantity: ${foodItem.quantity}"
        holder.foodImage.setImageResource(foodItem.imageResourceId)
    }

    override fun getItemCount() = foodItems.size
}