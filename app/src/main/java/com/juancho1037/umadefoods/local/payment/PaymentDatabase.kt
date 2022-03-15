package com.juancho1037.umadefoods.local.payment

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Payment::class],version = 1)
abstract class PaymentDatabase: RoomDatabase() {
    abstract fun PaymentDao(): PaymentDao
}