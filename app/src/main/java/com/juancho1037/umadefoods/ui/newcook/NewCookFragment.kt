package com.juancho1037.umadefoods.ui.newcook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.juancho1037.umadefoods.databinding.FragmentNewCookBinding
import com.juancho1037.umadefoods.model.Cook

class NewCookFragment : Fragment() {
	
	private lateinit var newCookBinding: FragmentNewCookBinding
	private lateinit var newCookViewModel: NewCookViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater ,
		container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		newCookBinding = FragmentNewCookBinding.inflate(inflater, container , false)
		newCookViewModel = ViewModelProvider(this)[NewCookViewModel::class.java]
		return newCookBinding.root
	}
	
	private fun checkEmail(email_: String): Boolean {
		return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()
	}
	
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
		with(newCookBinding){
			registerButton.setOnClickListener {
				val name = userNameInputText.text.toString()
				val email = newEmailInputText.text.toString()
			    val address = addressInputText.text.toString()
				val password = newPasswordInputText.text.toString()
				val repeatPassword = repPasswordInputText.text.toString()
				// Validación de e-mail y contraseña. Si son correctos, se crea el cocinero
				if (!checkEmail(email)) {
					Toast.makeText(
						requireContext() ,
						"Formato de e-mail incorrecto." ,
						Toast.LENGTH_SHORT
					).show()
				} else {
					if (password.length < 6) {
						Toast.makeText(
							requireContext(),
							"La contraseña debe ser mínimo de 6 dígitos" ,
							Toast.LENGTH_SHORT
						).show()
					} else {
						if (password != repeatPassword) {
							Toast.makeText(
								requireContext(),
								"Las contraseñas deben ser iguales" ,
								Toast.LENGTH_SHORT
							).show()
						} else {
							val cook = Cook(name, email, address, password)
							findNavController().navigate(NewCookFragmentDirections.actionNewCookFragmentToLoginFragment())
						}
					}
				}
			}
		}
	}
}