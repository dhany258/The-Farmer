package com.dicoding.farmers.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.farmers.data.FarmRepository
import com.dicoding.farmers.view.add.AddFarmViewModel
import com.dicoding.farmers.view.add.AddInventoryViewModel
import com.dicoding.farmers.view.inventory.InventoryViewModel
import com.dicoding.farmers.view.myfarm.MyFarmViewModel


class ViewModelFactory private constructor(private val farmRepository: FarmRepository) :
    ViewModelProvider.Factory {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(
                    FarmRepository.getInstance(context)
                )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AddFarmViewModel::class.java) -> {
                AddFarmViewModel(farmRepository) as T
            }
            modelClass.isAssignableFrom(InventoryViewModel::class.java) -> {
                InventoryViewModel(farmRepository) as T
            }
            modelClass.isAssignableFrom(MyFarmViewModel::class.java) -> {
                MyFarmViewModel(farmRepository) as T
            }
            modelClass.isAssignableFrom(AddInventoryViewModel::class.java) -> {
                AddInventoryViewModel(farmRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}
