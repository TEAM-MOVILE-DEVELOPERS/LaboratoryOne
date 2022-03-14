package com.juancho1037.umadefoods.ui.home.cooks_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.juancho1037.umadefoods.databinding.FragmentCooksListBinding
import com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks.Cook
import com.juancho1037.umadefoods.ui.home.dishes_list.DishesListFragment

class CooksListFragment : Fragment() {
	companion object {
		const val PAGE_TITLE = "Cocineros"
		@JvmStatic
		fun newInstance() = CooksListFragment()
	}
	private lateinit var cooklistBinding: FragmentCooksListBinding
	private lateinit var cooksViewModel: CooksViewModel
	private lateinit var cooksAdapter: CooksAdapter
	private var cooksList: ArrayList<Cook> = ArrayList()
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		cooklistBinding = FragmentCooksListBinding.inflate(inflater, container , false)
		cooksViewModel = ViewModelProvider(this)[CooksViewModel::class.java]
		return cooklistBinding.root
	}
	
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)

		cooksAdapter = CooksAdapter(cooksList)

		cooklistBinding.cooksRecyclerview.apply{
			layoutManager = LinearLayoutManager(this@CooksListFragment.requireContext())
			adapter = cooksAdapter
			setHasFixedSize(false)
		}
	}

	private fun onLoadCooksDoneSubscribe(cooksListLoaded: ArrayList<Cook>){
		cooksList = cooksListLoaded
		cooksAdapter.appendItems(cooksList)
	}
}