package com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Cook::class], version = 1)
abstract class CookDatabase : RoomDatabase(){
    abstract fun CookDao(): CookDao
}