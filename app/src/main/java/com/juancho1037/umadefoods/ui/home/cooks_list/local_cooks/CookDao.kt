package com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks

import androidx.room.*

@Dao
interface CookDao {

    @Insert
    suspend fun saveCook(cook: Cook)

    @Query("SELECT * FROM table_cooks WHERE cook_name LIKE :nameCook")
    suspend fun searchCook(nameCook: String): Cook

    @Delete
    suspend fun cookDelete(cook: Cook)

    @Query("SELECT * FROM table_cooks")
    suspend fun loadCook(): MutableList<Cook>

    @Update
    suspend fun updateCook(cook: Cook)

}