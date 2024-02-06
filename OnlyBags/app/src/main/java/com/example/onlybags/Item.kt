package com.example.onlybags

import android.graphics.Color

data class Item(
    val title: String,
    val description: String,
    val size: Int,
    val price: Int,
    val photo: Int,
    var isSelected: Boolean = false,
    var backgroundColor: Int = Color.WHITE
)


object ItemManager {

    val items: MutableList<Item> = mutableListOf()
    fun add(item:Item){
        items.add(item)
    }

    fun remove(index:Int){
        items.removeAt(index)
    }
}


