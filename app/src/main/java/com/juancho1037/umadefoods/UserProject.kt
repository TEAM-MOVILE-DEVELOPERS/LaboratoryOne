package com.juancho1037.umadefoods

import android.app.Application
import androidx.room.Room
import com.juancho1037.umadefoods.local.UserDatabase

class UserProject: Application() {

    companion object {
        lateinit var database: UserDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            UserDatabase::class.java,
            "user_db"
        ).build()
    }
}