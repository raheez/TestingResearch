package com.example.testingresearch.data.local

import androidx.room.PrimaryKey

data class ShoppingItem(
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null

) {
}