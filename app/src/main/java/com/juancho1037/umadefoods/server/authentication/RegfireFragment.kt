package com.juancho1037.umadefoods.server.authentication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.juancho1037.umadefoods.databinding.FragmentRegisterBinding
import com.juancho1037.umadefoods.ui.register.RegisterViewModel

class RegfireFragment: Fragment(){

    private lateinit var regfireBinding: FragmentRegisterBinding
    private lateinit var regfireViewModel: RegfireViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        regfireBinding = FragmentRegisterBinding.inflate(inflater,container,false)
        regfireViewModel = ViewModelProvider(this)[RegfireViewModel::class.java]
        return regfireBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        regfireViewModel.errorMsgDone.observe(this) { result ->
            onErrorMsgDoneSubscribe(result)
        }

        regfireViewModel.registerSucessDone.observe(this){ result->
            onRegisterSucessDoneSubscribe(result)
        }

        with(regfireBinding){
            registerButton.setOnClickListener {
                regfireViewModel.registerUser()
            }
        }

    }

    private fun onRegisterSucessDoneSubscribe(uid: String?){
        uid?.let{ Log.d("uid",it)}
    }

    private fun onErrorMsgDoneSubscribe(result: String?){
        Toast.makeText(baseContext,result,Toast.LENGTH_SHORT).show()
    }

    private fun createUser(uid: String?, email: String){

    }
}