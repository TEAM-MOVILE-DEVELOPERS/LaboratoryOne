package com.juancho1037.umadefoods.ui.home.dishes_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.juancho1037.umadefoods.databinding.FragmentDishesListBinding
import com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes.Dish
import kotlinx.coroutines.DelicateCoroutinesApi

class DishesListFragment : Fragment() {
	
	private lateinit var dishesListBinding: FragmentDishesListBinding
	private lateinit var dishesViewModel: DishesViewModel
	private lateinit var dishesAdapter: DishesAdapter
	private var dishesList: ArrayList<Dish> = ArrayList()
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		dishesListBinding = FragmentDishesListBinding.inflate(inflater , container , false)
		dishesViewModel = ViewModelProvider(this)[DishesViewModel::class.java]
		return dishesListBinding.root
	}
	
	@OptIn(DelicateCoroutinesApi::class)
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
		
		dishesAdapter = DishesAdapter(dishesList , { onDishItemClicked(it) })
		
		dishesListBinding.dishesRecyclerview.apply {
			layoutManager = LinearLayoutManager(this@DishesListFragment.requireContext())
			adapter = dishesAdapter
			setHasFixedSize(false)
		}
		
		dishesViewModel.loadDishes()
		dishesViewModel.loadDishDone.observe(viewLifecycleOwner) {
			onLoadDishesDoneSubscribe(it)
		}
	}
	
	private fun onDishItemClicked(dish: Dish) {
		findNavController().navigate(
			DishesListFragmentDirections.actionDishesListFragmentToDishesDetailFragment(
				dish
			)
		)
	}
	
	private fun onLoadDishesDoneSubscribe(dishesListLoaded: ArrayList<Dish>) {
//		disheslist = dishesListLoaded
//		dishesAdapter.appendItems(disheslist)
		// let es un condicional implícito que pregunta si cooksList no es nulo
		dishesList.let {
			dishesList = dishesListLoaded
			dishesAdapter.appendItems(dishesList)
		}
	}
}