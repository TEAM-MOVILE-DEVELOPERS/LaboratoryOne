package com.juancho1037.umadefoods

import android.app.Application
import androidx.room.Room
import com.juancho1037.umadefoods.local.UserDatabase
import com.juancho1037.umadefoods.local.payment.PaymentDatabase

class UMadeFoods: Application() {

    companion object {
        lateinit var database: UserDatabase
        lateinit var databasePay: PaymentDatabase

    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            UserDatabase::class.java,
            "user_db"
        ).build()

        databasePay = Room.databaseBuilder(
            this,
            PaymentDatabase::class.java,
            "paymentl_db"
        ).build()


    }
}