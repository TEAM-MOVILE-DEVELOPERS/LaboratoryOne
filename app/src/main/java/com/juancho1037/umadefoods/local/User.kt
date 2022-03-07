package com.juancho1037.umadefoods.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_users")
data class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") val id: Int,
    @ColumnInfo(name="name") val name: String="",
    @ColumnInfo(name="address") val address: String="",
    @ColumnInfo(name="email") val email: String="",
    @ColumnInfo(name="password") val password: String="",
    @ColumnInfo(name="repeat_password") val repeat_password: String=""
) : Serializable

