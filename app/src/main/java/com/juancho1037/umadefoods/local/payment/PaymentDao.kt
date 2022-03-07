package com.juancho1037.umadefoods.local.payment

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface PaymentDao
{
    @Insert
    fun savePayment(payment: Payment)
}