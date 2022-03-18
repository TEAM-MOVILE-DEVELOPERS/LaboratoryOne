package com.juancho1037.umadefoods.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
	private lateinit var homeBinding: FragmentHomeBinding
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		// Inflate the layout for this fragment
		homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
		return homeBinding.root
	}
	
	override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
		super.onViewCreated(view , savedInstanceState)
		
//		(activity as AppCompatActivity?)!!.supportActionBar!!.show()
		
		val labels = listOf(getString(R.string.title_cooks_list), getString(R.string.title_dishes_list))
		val navGraphsIds = listOf(R.navigation.dishes, R.navigation.cooks)
		// Call the view pager component from the layout and assign a childFragmentManager to its adapter property
		homeBinding.homeViewPager.adapter =
			HomeAdapter(
			childFragmentManager,
			viewLifecycleOwner.lifecycle,
			navGraphsIds
		)
	}
	
	class HomeAdapter(fragmentManager: FragmentManager ,
	                       lifecycle: Lifecycle ,
	                       private val navGraphsIds: List<Int>
	) : FragmentStateAdapter(fragmentManager, lifecycle) {
		override fun getItemCount(): Int = navGraphsIds.size
		
		override fun createFragment(position: Int): Fragment {
			// Return a NEW fragment instance in createFragment(int)
			return NavHostFragment.create(navGraphsIds[position])
		}
		
	}
	
	// Needed to avoid memory leaks
	// see: https://stackoverflow.com/a/62861424
	// and: https://stackoverflow.com/a/62184494
	override fun onDestroy() {
		homeBinding.homeViewPager.adapter = null
		super.onDestroy()
	}
}
