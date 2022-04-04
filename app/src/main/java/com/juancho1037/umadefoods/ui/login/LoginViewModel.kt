package com.juancho1037.umadefoods.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juancho1037.umadefoods.server.authentication.LoginFireRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {

    private val loginFireRepository = LoginFireRepository()

    private val msg: MutableLiveData<String> = MutableLiveData()
    val msgDone : LiveData<String> = msg

    fun ingresoDatos(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()){
            msg.value = "Todos los campos son obligatorios"
        }else{
            GlobalScope.launch(Dispatchers.IO){
                loginFireRepository.signInFirebase(email,password)
            }
        }
    }
}