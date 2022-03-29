package com.juancho1037.umadefoods.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.juancho1037.umadefoods.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay

class SplashFragment : Fragment() {
	
	private lateinit var splashBinding: FragmentSplashBinding
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		splashBinding = FragmentSplashBinding.inflate(inflater , container , false)
		// TODO(Reemplazar Handler por Executor ... ¿corrutinas?)
		Handler().postDelayed(
			{
				findNavController().navigate(SplashFragmentDirections.actionGlobalLoginNavigation())
			} , 2000
		)
//		goToNextFragment()
		return splashBinding.root
	}
	
	private suspend fun goToNextFragment() {
		delay(2000)
		findNavController().navigate(SplashFragmentDirections.actionGlobalLoginNavigation())
	}
	
}