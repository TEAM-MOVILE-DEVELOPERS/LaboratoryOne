package com.juancho1037.umadefoods.ui.delete

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.FragmentDeleteBinding

class DeleteFragment : Fragment() {
	
	companion object {
		fun newInstance() = DeleteFragment()
	}
	
	private lateinit var deleteBinding: FragmentDeleteBinding
	private lateinit var viewModel: DeleteViewModel
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_delete , container , false)
	}
}