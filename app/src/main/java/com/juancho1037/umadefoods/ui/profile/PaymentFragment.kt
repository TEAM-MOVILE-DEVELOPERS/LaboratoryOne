package com.juancho1037.umadefoods.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.juancho1037.umadefoods.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    private lateinit var paymentBinding: FragmentPaymentBinding
    private lateinit var paymentViewModel: PaymentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        paymentBinding = FragmentPaymentBinding.inflate(inflater,container,false)
        paymentViewModel = ViewModelProvider(this)[PaymentViewModel::class.java]
        return paymentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        paymentViewModel.msgDone.observe(viewLifecycleOwner) { result ->
            onMsgDoneSubscribe(result)
        }

        paymentViewModel.dataValidated.observe(viewLifecycleOwner,{result ->
            onDataValidate(result)
        })

        with(paymentBinding){
            addButton.setOnClickListener{
                paymentViewModel.enterDatos(
                    typeInputText.text.toString(),
                    numberInputText.text.toString(),
                    dateInputText.text.toString(),
                    codeInputText.text.toString()
                )
            }
        }
    }

    private fun onDataValidate(result: Boolean?) {
        with(paymentBinding){
            val type : String = typeInputText.text.toString()
            val number : String=numberInputText.text.toString()
            val date : String = dateInputText.text.toString()
            val code : String =  codeInputText.text.toString()
            paymentViewModel.savePayment(type, number, date, code)
        }
    }

    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()

    }


}

