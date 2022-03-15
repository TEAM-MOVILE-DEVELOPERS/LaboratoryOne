package com.juancho1037.umadefoods.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.juancho1037.umadefoods.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
	companion object {
		@JvmStatic
		fun newInstance() = RegisterFragment()
	}
	private lateinit var registerBinding: FragmentRegisterBinding
	private lateinit var registerViewModel: RegisterViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater ,
		container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		registerBinding = FragmentRegisterBinding.inflate(inflater, container , false)
		registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
		return registerBinding.root
	}
	
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
		registerViewModel.msgDone.observe(viewLifecycleOwner) { result ->
			onMsgDoneSubscribe(result)
		}
		registerViewModel.dataValidated.observe(viewLifecycleOwner){
			findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
		}
		with(registerBinding){
			registerButton.setOnClickListener {
				
				registerViewModel.enterDatos(
					userNameInputText.text.toString(),
					addressInputText.text.toString(),
					newEmailInputText.text.toString(),
					newPasswordInputText.text.toString(),
					repPasswordInputText.text.toString()
				)
			}
		}
	}
	private fun onMsgDoneSubscribe(msg: String?) {
		Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()
	}
}