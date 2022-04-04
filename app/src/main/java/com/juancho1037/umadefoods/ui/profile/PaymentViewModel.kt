package com.juancho1037.umadefoods.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.juancho1037.umadefoods.local.payment.PaymentRepository

class PaymentViewModel : ViewModel() {

    private val paymentRepository = PaymentRepository()
    private val msg: MutableLiveData<String> = MutableLiveData()
    private val db = FirebaseFirestore.getInstance()
    val msgDone: LiveData<String> = msg

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate



    fun enterDatos(type: String, number: String, date: String, code: String) {


        if (type.isEmpty() || number.isEmpty() || date.isEmpty() || code.isEmpty()) {
            msg.value = "Todos los campos son obligatorios"
        } else {
            db.collection("payments").document(type).get()
                .addOnSuccessListener { documento ->
                    if (documento.exists()) {
                        msg.value = "La tarjeta ya existe"
                    } else {
                        dataValidate.value = true
                        db.collection("payments").document(type).set(
                            hashMapOf(
                                "type" to type,
                                "number" to number,
                                "date" to date,
                                "code" to code
                            )
                        )
                    }

                }
        }
    }


    fun savePayment(type: String, number: String, date: String, code: String) {
        paymentRepository.savePayment(type, number, date, code)
    }

    fun editDatos(type: String, number: String, date: String, code: String) {

        dataValidate.value = true
        db.collection("payments").document(type).set(
            hashMapOf(
                "type" to type,
                "number" to number,
                "date" to date,
                "code" to code
            )
        )




    }


}



