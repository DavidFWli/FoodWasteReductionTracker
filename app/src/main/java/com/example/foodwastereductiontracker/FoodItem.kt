package com.example.foodwastereductiontracker

data class FoodItem(
    val name: String,
    val expiryDate: String,
    val quantity: Int,
    val imageResourceId: Int
)