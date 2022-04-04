package com.juancho1037.umadefoods.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.juancho1037.umadefoods.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
	
	private lateinit var loginBinding: FragmentLoginBinding
	private lateinit var loginViewModel: LoginViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		loginBinding = FragmentLoginBinding.inflate(inflater, container , false)
		loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
		return loginBinding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
		loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
		loginViewModel.msgDone.observe(viewLifecycleOwner) { result ->
			onMsgDoneSubscribe(result)
		}

		with(loginBinding){
			registerTextView.setOnClickListener {
				findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
			}
			loginButton.setOnClickListener {
				findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
				loginViewModel.ingresoDatos(
					emailInputText.text.toString(),
					passwordInputText.text.toString()
				)
			}
		}
	}
	private fun onMsgDoneSubscribe(msg: String?) {
		Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
	}
}