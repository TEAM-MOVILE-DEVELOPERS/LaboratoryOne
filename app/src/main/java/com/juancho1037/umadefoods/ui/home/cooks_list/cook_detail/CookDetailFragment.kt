package com.juancho1037.umadefoods.ui.home.cooks_list.cook_detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.juancho1037.umadefoods.databinding.FragmentCookDetailBinding
import com.juancho1037.umadefoods.ui.home.cooks_list.CooksViewModel

class CookDetailFragment : Fragment() {
	private lateinit var cookDetailBinding: FragmentCookDetailBinding
	private lateinit var cookDetailViewModel: CooksViewModel
	private val args : CookDetailFragmentArgs by navArgs() // se recive lo que venga
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		cookDetailBinding = FragmentCookDetailBinding.inflate(inflater, container , false)
		cookDetailViewModel = ViewModelProvider(this)[CooksViewModel::class.java]
		return cookDetailBinding.root
	}
	
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
		val cook = args.cook
		with(cookDetailBinding){
			cookNameTextView.text = cook.name
			addressTextView.text = cook.address
			emailTextView.text = cook.email
		}
	}
}