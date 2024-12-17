package com.dicoding.farmers.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "farm")
data class Farm(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val weight: Long,
    val age: Long,
    val description: String
)
