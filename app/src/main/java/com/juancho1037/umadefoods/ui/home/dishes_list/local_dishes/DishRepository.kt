package com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes

import com.juancho1037.umadefoods.UMadeFoods
import java.sql.Types

class DishRepository {

    suspend fun saveDish(
	    dish_name: String ,
	    food_kind: String ,
	    cook_name: String ,
	    price: String ,
	    preparation_time: String
    ){
        val dish = Dish(
	        id = Types.NULL ,
	        dish_name = dish_name ,
	        food_kind = food_kind ,
	        cook_name = cook_name ,
	        price = price ,
	        preparation_time = preparation_time
        )

        val dishDao: DishDao = UMadeFoods.dish_database.DishDao()
        dishDao.saveDish(dish)
    }

    suspend fun searchDish(nameDish: String): Dish {
        val dishDao: DishDao = UMadeFoods.dish_database.DishDao()
        return dishDao.searchDish(nameDish)
    }

    suspend fun deleteDish(dish: Dish) {
        val dishDao: DishDao = UMadeFoods.dish_database.DishDao()
        dishDao.dishDelete(dish)

    }

    suspend fun loadDish(): ArrayList<Dish> {
        val dishDao: DishDao = UMadeFoods.dish_database.DishDao()
        return dishDao.loadDish() as ArrayList<Dish>
    }

    suspend fun updateDish(dish: Dish) {
        val dishDao: DishDao = UMadeFoods.dish_database.DishDao()
        dishDao.updateDish(dish)
    }
}