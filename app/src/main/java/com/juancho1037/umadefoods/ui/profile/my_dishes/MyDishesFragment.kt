package com.juancho1037.umadefoods.ui.profile.my_dishes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.FragmentMyDishesBinding

class MyDishesFragment : Fragment() {
	private lateinit var myDishesBinding: FragmentMyDishesBinding
	private lateinit var viewModel: MyDishesViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		myDishesBinding = FragmentMyDishesBinding.inflate(inflater , container , false)
		return myDishesBinding.root
	}
	
}