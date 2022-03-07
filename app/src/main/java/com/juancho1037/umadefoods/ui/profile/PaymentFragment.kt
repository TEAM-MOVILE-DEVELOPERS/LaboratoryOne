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
    ): View? {

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
            onDataValitate(result)
        })

        with(paymentBinding){
            addButton.setOnClickListener{
                paymentViewModel.enterDatos(
                    typeInputEditText.text.toString(),
                    numberInputEditText.text.toString(),
                    dateInputEditText.text.toString(),
                    codeInputEditText.text.toString()

                )
            }
        }
    }

    private fun onDataValitate(result: Boolean?) {
        with(paymentBinding){
            val type : String = typeInputEditText.text.toString()
            val number : String=numberInputEditText.text.toString()
            val date : String = dateInputEditText.text.toString()
            val code : String =  codeInputEditText.text.toString()

            paymentViewModel.savePayment(type, number, date, code)
        }

    }

    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()

    }


}

