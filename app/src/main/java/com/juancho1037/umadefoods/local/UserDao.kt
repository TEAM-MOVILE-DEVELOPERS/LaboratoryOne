package com.juancho1037.umadefoods.local

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    suspend fun saveUser(user: User)

    @Query("SELECT * FROM table_users WHERE name LIKE :nameUser")
    suspend fun searchUser(nameUser: String): User

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM table_users")
    suspend fun loadUser(): MutableList<User>

    @Update
    suspend fun updateUser(user: User)
}