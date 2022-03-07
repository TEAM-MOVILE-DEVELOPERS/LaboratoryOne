package com.juancho1037.umadefoods.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {

    private val msg: MutableLiveData<String> = MutableLiveData()
    val msgDone : LiveData<String> = msg

    fun ingresoDatos(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()){
            msg.value = "Todos los campos son obligatorios"
        }else{
            if (email=="vane" && password == "123"){
                msg.value="Entro a MainActivity"
                //investigar como pasar al MainActivity

            }
            else{
                msg.value="Usuario y contraseña incorrectas"
            }
        }

    }

}