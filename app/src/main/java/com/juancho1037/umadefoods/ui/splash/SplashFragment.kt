package com.juancho1037.umadefoods.ui.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.juancho1037.umadefoods.databinding.FragmentSplashBinding
import java.util.*
import kotlin.concurrent.timerTask

class SplashFragment : Fragment() {
	
	private lateinit var splashBinding: FragmentSplashBinding
	private lateinit var splashViewModel: SplashViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]
		splashBinding = FragmentSplashBinding.inflate(inflater,container , false)
		val timer = Timer()
		timer.schedule(
			timerTask {
				goToLoginFragment()
			}, 2000
		)
		return splashBinding.root
	}
	
	private fun goToLoginFragment(){
		findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
	}
}