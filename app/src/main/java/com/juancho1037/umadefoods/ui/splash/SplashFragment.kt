package com.juancho1037.umadefoods.ui.splash


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.juancho1037.umadefoods.databinding.FragmentSplashBinding
import com.juancho1037.umadefoods.ui.main.MainActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashFragment : Fragment() {
	
	private lateinit var splashBinding: FragmentSplashBinding
	private lateinit var auth: FirebaseAuth
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		splashBinding = FragmentSplashBinding.inflate(inflater,container , false)
		auth = Firebase.auth
		val timer = Timer()
		timer.schedule(
			timerTask {
				if(auth.currentUser == null) goToLoginFragment() else goToMainActivity()
			}, 2000
		)
		return splashBinding.root
	}
	
	private fun goToLoginFragment(){
		findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
	}

	private fun goToMainActivity(){
		//TODO: NAVENGACION HACIA MAIN ACTIVITY
	}
}