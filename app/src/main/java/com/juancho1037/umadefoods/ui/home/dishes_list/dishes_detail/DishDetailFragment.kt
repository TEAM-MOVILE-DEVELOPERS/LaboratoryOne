package com.juancho1037.umadefoods.ui.home.dishes_list.dishes_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.FragmentDishDetailBinding
import com.juancho1037.umadefoods.ui.home.dishes_list.DishesViewModel

class DishDetailFragment : Fragment() {
	private lateinit var dishDetailBinding: FragmentDishDetailBinding
	private lateinit var dishesViewModel: DishesViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		// Inflate the layout for this fragment
		dishDetailBinding = FragmentDishDetailBinding.inflate(inflater , container , false)
		dishesViewModel = ViewModelProvider(this)[DishesViewModel::class.java]
		return dishDetailBinding.root
	}
    
}