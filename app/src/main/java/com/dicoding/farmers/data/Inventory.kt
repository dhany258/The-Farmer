package com.dicoding.farmers.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventory")
data class Inventory(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val inventoryName: String,
    val inventoryQuantity: Int
)
