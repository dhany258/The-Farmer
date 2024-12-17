package com.dicoding.farmers.view.inventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.dicoding.farmers.data.FarmRepository
import com.dicoding.farmers.data.Inventory

class InventoryViewModel(private val repository: FarmRepository): ViewModel() {
    fun getInventory():LiveData<List<Inventory>> = repository.getAllInventory()
}