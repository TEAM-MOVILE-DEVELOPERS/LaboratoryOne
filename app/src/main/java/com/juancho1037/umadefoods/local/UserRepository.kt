package com.juancho1037.umadefoods.local

import com.juancho1037.umadefoods.UMadeFoods

import java.sql.Types

class UserRepository {

    suspend fun saveUser(
        name: String,
        address: String,
        email: String,
        password: String,
        repeat_password: String,
    ){
        val user = User(
            id = Types.NULL,
            name = name,
            address = address,
            email = email,
            password = password,
            repeat_password = repeat_password
        )

        val userDao: UserDao = UMadeFoods.database.UserDao()
        userDao.saveUser(user)
    }

    suspend fun searchUser(nameUser: String): User {
        val userDao: UserDao = UMadeFoods.database.UserDao()
        return userDao.searchUser(nameUser)
    }

    suspend fun deleteUser(user: User) {
        val userDao: UserDao = UMadeFoods.database.UserDao()
        userDao.deleteUser(user)
    }

    suspend fun loadUser(): ArrayList<User> {
        val userDao: UserDao = UMadeFoods.database.UserDao()
        return userDao.loadUser() as ArrayList<User>
    }

    suspend fun updateUser(user: User) {
        val userDao: UserDao = UMadeFoods.database.UserDao()
        userDao.updateUser(user)
    }
}