package com.juancho1037.umadefoods.ui.home.cooks_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks.Cook
import com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks.CookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CooksViewModel : ViewModel() {

    val cooksRepository = CookRepository()

    private val loadCooks: MutableLiveData<ArrayList<Cook>> = MutableLiveData()
    val loadCookDone: LiveData<ArrayList<Cook>> = loadCooks

    fun loadCooks(){
        GlobalScope.launch(Dispatchers.IO){
            loadCooks.postValue(cooksRepository.loadCook())
        }
    }
}