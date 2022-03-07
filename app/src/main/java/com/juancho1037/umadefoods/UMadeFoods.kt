package com.juancho1037.umadefoods

import android.app.Application
import androidx.room.Room
import com.juancho1037.umadefoods.local.UserDatabase
import com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks.CookDatabase
import com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes.DishDatabase

class UMadeFoods: Application() {

    companion object {
        lateinit var database: UserDatabase
        lateinit var dish_database: DishDatabase
        lateinit var cook_database: CookDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            UserDatabase::class.java,
            "user_db"
        ).build()

        dish_database = Room.databaseBuilder(
            this,
            DishDatabase::class.java,
            "dish_db"
        ).build()

        cook_database = Room.databaseBuilder(
            this,
            CookDatabase::class.java,
            "cook.db"
        ).build()
    }
}