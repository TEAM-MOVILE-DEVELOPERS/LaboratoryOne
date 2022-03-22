package com.juancho1037.umadefoods.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commitNow
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
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
		val navGraphsIds = listOf(R.navigation.dishes, R.navigation.cooks)
		// Call the view pager component from the layout and assign a childFragmentManager to its adapter property
		homeBinding.homeViewPager.adapter =
			HomeAdapter(
			childFragmentManager,
			viewLifecycleOwner.lifecycle,
			navGraphsIds
		)
		val labels = listOf(getString(R.string.title_dishes_list), getString(R.string.title_cooks_list))
		val tabLayout = homeBinding.tabLayout
		val tabLayoutMediator = TabLayoutMediator(tabLayout, homeBinding.homeViewPager) {tab, position ->
			tab.text = (labels[position])
		}
		tabLayoutMediator.attach()
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
		
		init {
			// Needs: "androidx.viewpager2:viewpager2:1.1.0-alpha01" or higher
			// Taken from: https://stackoverflow.com/a/62629996
			// Add a FragmentTransactionCallback to handle changing
			// the primary navigation fragment
			registerFragmentTransactionCallback(object : FragmentTransactionCallback() {
				override fun onFragmentMaxLifecyclePreUpdated(
					fragment: Fragment,
					maxLifecycleState: Lifecycle.State
				) = if (maxLifecycleState == Lifecycle.State.RESUMED) {
					// This fragment is becoming the active Fragment - set it to
					// the primary navigation fragment in the OnPostEventListener
					OnPostEventListener {
						fragment.parentFragmentManager.commitNow {
							setPrimaryNavigationFragment(fragment)
						}
					}
				} else {
					super.onFragmentMaxLifecyclePreUpdated(fragment, maxLifecycleState)
				}
			})
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
