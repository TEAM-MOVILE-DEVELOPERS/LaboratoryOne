package com.juancho1037.umadefoods.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juancho1037.umadefoods.databinding.FragmentProfileBinding
import androidx.navigation.fragment.findNavController

class ProfileFragment : Fragment() {
	private lateinit var profileBinding: FragmentProfileBinding
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		// Inflate the layout for this fragment
		profileBinding = FragmentProfileBinding.inflate(inflater , container , false)
		return profileBinding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
		
		with(profileBinding) {
			paymentMethodsLayout.setOnClickListener {
				findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToPaymentFragment())
			}
			myDishesLayout.setOnClickListener {
				findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToMyDishesFragment())
			}
		}
	}
}