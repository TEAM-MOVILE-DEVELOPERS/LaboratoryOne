package com.juancho1037.umadefoods.ui.home.dishes_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes.Dish
import com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes.DishRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DishesViewModel : ViewModel() {

    val dishRepository = DishRepository()

    private val loadDishes: MutableLiveData<ArrayList<Dish>> = MutableLiveData()
    val loadDishDone: LiveData<ArrayList<Dish>> = loadDishes

    fun loadDishes(){
        GlobalScope.launch(Dispatchers.IO){
            loadDishes.postValue(dishRepository.loadDish())
        }
    }
}