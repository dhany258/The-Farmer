package com.dicoding.farmers.view.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.farmers.data.Farm
import com.dicoding.farmers.data.FarmRepository
import kotlinx.coroutines.launch

class AddFarmViewModel (private val repository: FarmRepository): ViewModel() {
    fun insertInventory(name: String, weight: Long, age: Long, description: String){
        val newInventory = Farm(
            name = name,
            weight = weight,
            age = age,
            description = description,
        )
        viewModelScope.launch {
            repository.insertFarm(newInventory)
        }
    }
}