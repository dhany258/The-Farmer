package com.dicoding.farmers.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData


class FarmRepository(private val farmDao: FarmDao) {
    companion object {
        const val PAGE_SIZE = 30
        const val PLACEHOLDERS = false

        @Volatile
        private var instance: FarmRepository? = null

        fun getInstance(context: Context): FarmRepository {
            return instance ?: synchronized(this) {
                val database = FarmDatabase.getInstance(context)
                FarmRepository(database.farmDao()).also { instance = it }
            }
        }
    }

    fun getAllFarm(): LiveData<PagingData<Farm>>{
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = PLACEHOLDERS
            ),
            pagingSourceFactory = {farmDao.getFarms()}
        ).flow.asLiveData()
    }



    fun getFarmById(farmId: Int): LiveData<Farm> {
        return farmDao.getDataById(farmId)
    }


    suspend fun insertFarm(farm: Farm): Long {
        return farmDao.insertData(farm)
    }

    suspend fun deleteFarm(farm: Farm) {
        farmDao.deleteData(farm)
    }

    suspend fun insertInventory(inventory: Inventory): Long {
        return farmDao.insertInventory(inventory)
    }

    fun getAllInventory(): LiveData<List<Inventory>> {
        return farmDao.getInventory()
    }

}