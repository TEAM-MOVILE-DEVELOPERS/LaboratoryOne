package com.juancho1037.umadefoods.ui.login

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.juancho1037.umadefoods.databinding.FragmentLoginBinding
import com.juancho1037.umadefoods.ui.main.MainActivity

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
				findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainActivity())
//				val intent = Intent(requireContext(), MainActivity::class.java)
//		        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
//                startActivity(intent)
			}
		}
	}
	private fun onMsgDoneSubscribe(msg: String?) {
		Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
	}
}