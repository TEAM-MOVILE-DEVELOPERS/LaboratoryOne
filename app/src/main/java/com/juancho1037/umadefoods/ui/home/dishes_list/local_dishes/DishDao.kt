package com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes

import androidx.room.*

@Dao
interface DishDao {

    @Insert
    suspend fun saveDish(dish: Dish)

    @Query("SELECT * FROM table_dishes WHERE dish_name LIKE :nameDish")
    suspend fun searchDish(nameDish: String): Dish

    @Delete
    suspend fun dishDelete(dish: Dish)

    @Query("SELECT * FROM table_dishes")
    suspend fun loadDish(): MutableList<Dish>

    @Update
    suspend fun updateDish(dish: Dish)

}