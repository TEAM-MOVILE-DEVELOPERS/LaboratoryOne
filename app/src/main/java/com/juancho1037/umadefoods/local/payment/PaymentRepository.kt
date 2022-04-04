package com.juancho1037.umadefoods.local.payment
import com.juancho1037.umadefoods.UMadeFoods
import java.sql.Types.NULL

class PaymentRepository {
    fun savePayment(type: String, number: String, date: String, code: String) {
        val payment = Payment(
            id = NULL,
            type = type,
            number = number,
            date = date,
            cvc = code


        )

        val paymentDao : PaymentDao =UMadeFoods.databasePay.PaymentDao()
        //TODO: "Verificar implementación"
//        paymentDao.savePayment(payment)


    }
}