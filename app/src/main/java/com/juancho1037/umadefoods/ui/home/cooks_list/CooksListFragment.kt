package com.juancho1037.umadefoods.ui.home.cooks_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.juancho1037.umadefoods.databinding.FragmentCooksListBinding

class CooksListFragment : Fragment() {
	private lateinit var cooksListBinding: FragmentCooksListBinding
	private lateinit var cooksViewModel: CooksViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		cooksListBinding = FragmentCooksListBinding.inflate(inflater, container , false)
		cooksViewModel = ViewModelProvider(this)[CooksViewModel::class.java]
		return cooksListBinding.root
	}
	
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
		
	}
}