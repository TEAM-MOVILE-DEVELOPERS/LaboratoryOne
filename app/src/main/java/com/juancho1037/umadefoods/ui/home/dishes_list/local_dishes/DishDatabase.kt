package com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Dish::class], version = 1)
abstract class DishDatabase : RoomDatabase(){
    abstract fun DishDao(): DishDao
}