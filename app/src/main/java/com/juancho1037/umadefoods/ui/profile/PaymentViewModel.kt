package com.juancho1037.umadefoods.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juancho1037.umadefoods.local.payment.PaymentRepository

class PaymentViewModel : ViewModel() {

    private val paymentRepository = PaymentRepository()
    private val msg : MutableLiveData<String> = MutableLiveData()
    val msgDone : LiveData<String> = msg

    private val dataValidate : MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate

    fun enterDatos(type: String, number: String, date: String, code: String) {
        if(type.isEmpty() || number.isEmpty() || date.isEmpty() || code.isEmpty())
        {
            msg.value = "Todos los campos son obligatorios"
        }
        else{
            dataValidate.value = true

        }


    }

    fun savePayment(type: String, number: String, date: String, code: String) {
        paymentRepository.savePayment(type,number,date,code)

    }

}