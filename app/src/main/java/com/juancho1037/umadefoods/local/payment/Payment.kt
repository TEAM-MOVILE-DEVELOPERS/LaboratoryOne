package com.juancho1037.umadefoods.local.payment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_payment")
data class Payment(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") val id: Int,
    @ColumnInfo(name="type") val type: String,
    @ColumnInfo(name="number") val number: String,
    @ColumnInfo(name="date") val date: String,
    @ColumnInfo(name="cvc") val cvc: String
): Serializable