package com.sumon.groceryapp

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
//Dao : DataAccessObject
interface GroceryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : GroceryItems)

    @Delete
    suspend fun delete(item : GroceryItems)

    @Query("SELECT * FROM grocery_items")
    fun getAllGroceryItems() : LiveData<List<GroceryItems>>
}