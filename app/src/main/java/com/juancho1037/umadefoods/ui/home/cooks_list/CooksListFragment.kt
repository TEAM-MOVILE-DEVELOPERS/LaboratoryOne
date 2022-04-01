package com.juancho1037.umadefoods.ui.home.cooks_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.juancho1037.umadefoods.databinding.FragmentCooksListBinding
import com.juancho1037.umadefoods.ui.home.cooks_list.local_cooks.Cook
import kotlinx.coroutines.DelicateCoroutinesApi

class CooksListFragment : Fragment() {
	
	private lateinit var cooksListBinding: FragmentCooksListBinding
	private lateinit var cooksViewModel: CooksViewModel
	private lateinit var cooksAdapter: CooksAdapter
	private var cooksList: ArrayList<Cook> = ArrayList()
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		cooksListBinding = FragmentCooksListBinding.inflate(inflater , container , false)
		cooksViewModel = ViewModelProvider(this)[CooksViewModel::class.java]
		return cooksListBinding.root
	}
	
	@OptIn(DelicateCoroutinesApi::class)
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
		
		cooksAdapter = CooksAdapter(cooksList , { onCookItemClicked(it) })
		
		cooksListBinding.cooksRecyclerview.apply {
			layoutManager = LinearLayoutManager(this@CooksListFragment.requireContext())
			adapter = cooksAdapter
			setHasFixedSize(false)
		}
		
		cooksViewModel.loadCooks()
		cooksViewModel.loadCooksDone.observe(viewLifecycleOwner) {
			onLoadCooksDoneSubscribe(it)
		}
		
	}
	
	private fun onCookItemClicked(cook: Cook) {
		findNavController().navigate(
			CooksListFragmentDirections.actionCooksListFragmentToCookDetailFragment(
				cook
			)
		)
	}
	
	private fun onLoadCooksDoneSubscribe(cooksListLoaded: ArrayList<Cook>) {
		/*cooksList = cooksListLoaded
		cooksAdapter.appendItems(cooksList)*/
		// let es un condicional implícito que pregunta si cooksList no es nulo
		cooksList.let {
			cooksList = cooksListLoaded
			cooksAdapter.appendItems(cooksList)
		}
	}
}