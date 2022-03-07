package com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks

import androidx.room.ColumnInfo
import com.juancho1037.umadefoods.UMadeFoods
import com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks.Cook
import java.sql.Types

class CookRepository {

    suspend fun saveCook(
        rank: String,
        cook_name: String,
        food_kind: String,
        location: String,

    ){
        val cook = Cook(
            id = Types.NULL,
            rank = rank,
            cook_name = cook_name,
            food_kind = food_kind,
            location = location
        )

        val cookDao: CookDao = UMadeFoods.cook_database.CookDao()
        cookDao.saveCook(cook)
    }

    suspend fun searchDish(nameCook: String): Cook {
        val cookDao: CookDao = UMadeFoods.cook_database.CookDao()
        return cookDao.searchCook(nameCook)
    }

    suspend fun deleteCook(cook: Cook) {
        val cookDao: CookDao = UMadeFoods.cook_database.CookDao()
        cookDao.cookDelete(cook)
    }

    suspend fun loadCook(): ArrayList<Cook> {
        val cookDao: CookDao = UMadeFoods.cook_database.CookDao()
        return cookDao.loadCook() as ArrayList<Cook>
    }

    suspend fun updateCook(cook: Cook) {
        val cookDao: CookDao = UMadeFoods.cook_database.CookDao()
        cookDao.updateCook(cook)
    }
}