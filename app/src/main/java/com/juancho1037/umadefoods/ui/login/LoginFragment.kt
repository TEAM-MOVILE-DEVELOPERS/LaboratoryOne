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
//	private val args: LoginFragmentArgs by navArgs()
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		loginBinding = FragmentLoginBinding.inflate(inflater, container , false)
		loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
		return loginBinding.root
	}
	
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
//		val cook = args.cook
//		val emailReceived = cook.email
//		val passwordReceived = cook.password
		with(loginBinding){
			registerTextView.setOnClickListener {
				findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
			}
			loginButton.setOnClickListener {
				val email = emailInputText.text.toString()
				val password = passwordInputText.text.toString()
				if (email.isEmpty() || password.isEmpty()) {
					Toast.makeText(requireContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
				} else{
//					if (email!=emailReceived || password!=passwordReceived) {
//						Toast.makeText(requireContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
//					} else {
						// TODO: limpiar la pila para que se salga de la app al back pressed
//						findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToCookDetailFragment())
//					}
				}
			}
		}
	}
	
}