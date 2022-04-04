package com.juancho1037.umadefoods.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.juancho1037.umadefoods.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    private lateinit var paymentBinding: FragmentPaymentBinding
    private lateinit var paymentViewModel: PaymentViewModel
    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        paymentBinding = FragmentPaymentBinding.inflate(inflater, container, false)
        paymentViewModel = ViewModelProvider(this)[PaymentViewModel::class.java]
        return paymentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        paymentViewModel.msgDone.observe(viewLifecycleOwner) { result ->
            onMsgDoneSubscribe(result)
        }

        paymentViewModel.dataValidated.observe(viewLifecycleOwner, {
            onDataValidate()
        })
        auth = Firebase.auth


        with(paymentBinding) {
            addButton.setOnClickListener {
                paymentViewModel.enterDatos(
                    typeInputText.text.toString(),
                    numberInputText.text.toString(),
                    dateInputText.text.toString(),
                    codeInputText.text.toString()
                )
                val type = typeInputText.text.toString()

                db.collection("payments").document(type).set(
                    hashMapOf(
                        "type" to typeInputText.text.toString(),
                        "number" to numberInputText.text.toString(),
                        "date" to dateInputText.text.toString(),
                        "code" to codeInputText.text.toString()
                    )
                )


            }

            getButton.setOnClickListener {
                if (typeInputText.text.toString().isEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "Se requiere el tipo de de tarjeta",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    db.collection("payments").document(typeInputText.text.toString()).get()
                        .addOnSuccessListener {
                            numberInputText.setText(it.get("number") as String?)
                            dateInputText.setText(it.get("date") as String?)
                            codeInputText.setText(it.get("code") as String?)
                            infoTextView.text =(it.get("type") as String?)
                            infoNumberTextView.text = it.get("number") as String?

                        }
                }

            }

            deleteButton.setOnClickListener {
                if (typeInputText.text.toString().isEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "Se requiere el tipo de de tarjeta",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    db.collection("payments").document(typeInputText.text.toString()).delete()
                    Toast.makeText(
                        requireContext(),
                        "La tarjeta se eliminó con éxito",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }

    private fun onDataValidate() {
        with(paymentBinding) {
            val type: String = typeInputText.text.toString()
            val number: String = numberInputText.text.toString()
            val date: String = dateInputText.text.toString()
            val code: String = codeInputText.text.toString()
            paymentViewModel.savePayment(type, number, date, code)

            infoTextView.text = type
            infoNumberTextView.text=number
        }


    }

    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()

    }


}

