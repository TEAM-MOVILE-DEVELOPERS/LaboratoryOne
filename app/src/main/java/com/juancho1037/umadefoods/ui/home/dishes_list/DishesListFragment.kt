package com.juancho1037.umadefoods.ui.home.dishes_list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.juancho1037.umadefoods.databinding.FragmentDishesListBinding
import com.juancho1037.umadefoods.ui.home.dishes_list.local_dishes.Dish

class DishesListFragment : Fragment() {
    
    companion object {
        const val PAGE_TITLE : String = "Menú"
        @JvmStatic
        fun newInstance() = DishesListFragment()
    }
    
    private lateinit var listBinding: FragmentDishesListBinding
    private lateinit var listviewModel: DishesViewModel
    private lateinit var dishesAdapter: DishesAdapter
    private var disheslist: ArrayList<Dish> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentDishesListBinding.inflate(inflater,container,false)
        listviewModel = ViewModelProvider(this)[DishesViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dishesAdapter = DishesAdapter(disheslist)

        listBinding.dishesRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@DishesListFragment.requireContext())
            adapter = dishesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onLoadDishesDoneSubscribe(dishesListLoaded: ArrayList<Dish>){
        disheslist = dishesListLoaded
        dishesAdapter.appendItems(disheslist)
    }
}