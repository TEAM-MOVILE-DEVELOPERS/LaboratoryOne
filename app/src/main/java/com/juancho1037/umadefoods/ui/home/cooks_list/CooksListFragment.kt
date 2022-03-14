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
		@JvmStatic
		fun newInstance() = CooksListFragment()
	}
	private lateinit var cooklistBinding: FragmentCooksListBinding
	private lateinit var cooksViewModel: CooksViewModel
	private lateinit var cooksAdapter: CooksAdapter
	private var cookslist: ArrayList<Cook> = ArrayList()
	
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

		cooksAdapter = CooksAdapter(cookslist)

		cooklistBinding.cooksRecyclerview.apply{
			layoutManager = LinearLayoutManager(this@CooksListFragment.requireContext())
			adapter = cooksAdapter
			setHasFixedSize(false)
		}
	}

	private fun onLoadCooksDoneSubscribe(cooksListLoaded: ArrayList<Cook>){
		cookslist = cooksListLoaded
		cooksAdapter.appendItems(cookslist)
	}
}