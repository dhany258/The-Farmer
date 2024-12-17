package com.dicoding.farmers.data

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query



@Dao
interface FarmDao {

    @Query("SELECT * FROM farm WHERE id = :farmId")
    fun getDataById(farmId: Int): LiveData<Farm>

    @Query("SELECT * FROM farm")
    fun getFarms(): PagingSource<Int, Farm>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(farm: Farm): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg farm: Farm)

    @Delete
    suspend fun deleteData(farm: Farm)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertInventory(inventory: Inventory): Long

    @Query("SELECT * FROM inventory")
    fun getInventory(): LiveData<List<Inventory>>
}