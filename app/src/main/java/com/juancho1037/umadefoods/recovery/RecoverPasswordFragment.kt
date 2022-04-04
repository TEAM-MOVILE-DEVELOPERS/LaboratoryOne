package com.juancho1037.umadefoods.recovery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.juancho1037.umadefoods.databinding.FragmentRecoveryPasswordBinding

class RecoverPasswordFragment : Fragment() {

    private lateinit var recoveryPasswordBinding: FragmentRecoveryPasswordBinding
    //private val recoverViewModel: RecoverPasswordViewModel by lifecycleScope.viewModel(this)

    companion object {
        fun newInstance() = RecoverPasswordFragment()
    }

    private lateinit var viewModel: RecoverPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recoveryPasswordBinding = FragmentRecoveryPasswordBinding.inflate(inflater, container, false)
        return recoveryPasswordBinding.root
    }

    //TODO: funciones para layout de recuperar contraseña
/*    private fun addSubscriptions() {
        recoveryViewModel.ui.observe(viewLifecycleOwner, Observer(::uiUpdate))
        recoveryViewModel.onIsLoading.observe(viewLifecycleOwner, Observer {
            result ->onIsLoadingSubscribed(result)
        })
        recoveryViewModel.onRecoveryPassword.observe(viewLifecycleOwner, {
            result ->onRecoveryPasswordSuscribed(result)
        })
    }*/

}