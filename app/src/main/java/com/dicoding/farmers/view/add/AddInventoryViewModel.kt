package com.dicoding.farmers.view.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.farmers.data.FarmRepository
import com.dicoding.farmers.data.Inventory
import kotlinx.coroutines.launch

class AddInventoryViewModel(private val repository: FarmRepository): ViewModel() {
    fun insertInventory(name: String, quantity: Int){
        val newInventory = Inventory(
            inventoryName = name,
            inventoryQuantity = quantity
        )
        viewModelScope.launch {
            repository.insertInventory(newInventory)
        }
    }
}