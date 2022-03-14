package com.juancho1037.umadefoods.ui.shopping_cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.juancho1037.umadefoods.databinding.FragmentShoppingCartBinding
import com.juancho1037.umadefoods.ui.home.dishes_list.DishesListFragment

class ShoppingCartFragment : Fragment() {
	companion object {
		@JvmStatic
		fun newInstance() = ShoppingCartFragment()
	}
	private lateinit var shoppingCartBinding: FragmentShoppingCartBinding
	private lateinit var shoppingCartViewModel: ShoppingCartViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		shoppingCartBinding = FragmentShoppingCartBinding.inflate(inflater, container , false)
		shoppingCartViewModel = ViewModelProvider(this)[ShoppingCartViewModel::class.java]
		return shoppingCartBinding.root
	}
	
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
	}
}