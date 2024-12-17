package com.dicoding.farmers.view.myfarm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.dicoding.farmers.data.Farm
import com.dicoding.farmers.data.FarmRepository

class MyFarmViewModel(private val repository: FarmRepository): ViewModel() {
    fun getAllFarm(): LiveData<PagingData<Farm>> = repository.getAllFarm()
}