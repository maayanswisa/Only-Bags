package com.example.onlybags

import android.graphics.Color


data class Cart(
    val title: String,
    val description: String,
    val size: Int,
    val price: Int,
    val photo: Int,
    var isSelected: Boolean = false,
    var backgroundColor: Int = Color.WHITE
)


object CartManager {
    val selectedItems: MutableList<Item> = mutableListOf()

    fun add(item:Item){
        CartManager.selectedItems.add(item)
    }

    fun remove(index:Int){
        CartManager.selectedItems.removeAt(index)

    }

    fun calculateTotalPrice(): Int {
        var totalPrice = 0
        for (item in selectedItems) {
            totalPrice += item.price
        }
        return totalPrice
    }


    fun calculateItemCount(): Int {
        val itemCount =CartManager.selectedItems.size
        return itemCount
    }
}