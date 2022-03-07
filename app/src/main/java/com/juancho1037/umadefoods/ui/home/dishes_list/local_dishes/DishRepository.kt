package com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes

import com.juancho1037.umadefoods.UMadeFoods
import java.sql.Types

class DishRepository {

    suspend fun saveDish(
        food_kind: String,
        dish_name: String,
        cook_name: String,
        price: String,
        time_preparation:String
    ){
        val dish = Dish(
            id = Types.NULL,
            food_kind = food_kind,
            dish_name = dish_name,
            cook_name = cook_name,
            price = price,
            time_preparation = time_preparation
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