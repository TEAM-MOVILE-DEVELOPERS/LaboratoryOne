package com.juancho1037.umadefoods.ui.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.juancho1037.umadefoods.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
	companion object {
		@JvmStatic
		fun newInstance() =	FavoritesFragment()
	}
	private lateinit var favoritesBinding: FragmentFavoritesBinding
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		// Inflate the layout for this fragment
		favoritesBinding = FragmentFavoritesBinding.inflate(inflater, container , false)
		return favoritesBinding.root
	}
}