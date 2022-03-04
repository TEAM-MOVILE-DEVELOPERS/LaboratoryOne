package com.juancho1037.umadefoods.ui.home.cooks_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.juancho1037.umadefoods.databinding.FragmentListBinding

class ListFragment : Fragment() {
	private lateinit var listBinding: FragmentListBinding
	private lateinit var listViewModel: ListViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		listBinding = FragmentListBinding.inflate(inflater, container , false)
		listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
		return listBinding.root
	}
	
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
		
	}
}