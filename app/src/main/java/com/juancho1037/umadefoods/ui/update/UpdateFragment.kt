package com.juancho1037.umadefoods.ui.update

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juancho1037.umadefoods.R

class UpdateFragment : Fragment() {
	
	companion object {
		fun newInstance() = UpdateFragment()
	}
	
	private lateinit var viewModel: UpdateViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_update , container , false)
	}
}