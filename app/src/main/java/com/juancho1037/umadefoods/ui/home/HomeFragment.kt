package com.juancho1037.umadefoods.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.juancho1037.umadefoods.databinding.FragmentHomeBinding
import com.juancho1037.umadefoods.ui.home.cooks_list.CooksListFragment
import com.juancho1037.umadefoods.ui.home.dishes_list.DishesListFragment

class HomeFragment : Fragment() {
	private lateinit var homeBinding: FragmentHomeBinding
	
	override fun onCreateView(
		inflater: LayoutInflater , container: ViewGroup? ,
		savedInstanceState: Bundle?
	): View {
		// Inflate the layout for this fragment
		homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
		// Call the view pager component from the layout and assign a childFragmentManager to its adapter property
		homeBinding.viewPager.adapter = ViewPagerAdapter(childFragmentManager)
		return homeBinding.root
	}
	
	companion object {
		fun newInstance():	HomeFragment {
			return HomeFragment()
		}
	}
	
	// Needed to avoid memory leaks
	// see: https://stackoverflow.com/a/62861424
	// and: https://stackoverflow.com/a/62184494
	override fun onDestroy() {
		homeBinding.viewPager.adapter = null
		super.onDestroy()
	}
	
	class ViewPagerAdapter(fm: FragmentManager?) :
		FragmentStatePagerAdapter(fm!!) {
		override fun getCount(): Int {
			// Number of fragments
			return 2
		}
		
		override fun getItem(position: Int): Fragment {
			return when (position) {
				0 -> DishesListFragment.newInstance()
				else -> CooksListFragment.newInstance()
			}
		}
		
		override fun getPageTitle(position: Int): CharSequence {
			return when (position) {
				0 -> DishesListFragment.PAGE_TITLE
				else -> CooksListFragment.PAGE_TITLE
			}
		}
	}
	
}