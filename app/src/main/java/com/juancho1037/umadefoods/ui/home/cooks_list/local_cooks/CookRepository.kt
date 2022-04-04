package com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks

import com.juancho1037.umadefoods.UMadeFoods
import java.sql.Types

class CookRepository {

    suspend fun saveCook(
	    cook_name: String ,
	    rank: String ,
	    food_kind: String ,
	    location: String ,
	
	    ) {
	    val cook = Cook(
		    id = Types.NULL ,
		    cook_name = cook_name ,
		    rank = rank ,
		    food_kind = food_kind ,
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
        cookDao.deleteCook(cook)
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