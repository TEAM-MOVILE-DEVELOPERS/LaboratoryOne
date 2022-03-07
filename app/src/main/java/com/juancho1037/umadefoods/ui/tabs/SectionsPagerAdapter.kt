package com.juancho1037.umadefoods.ui.tabs

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.ui.login.LoginFragment
import com.juancho1037.umadefoods.ui.profile.ProfileFragment
import com.juancho1037.umadefoods.ui.register.RegisterFragment
import com.juancho1037.umadefoods.ui.shopping_cart.ShoppingCartFragment

private val TAB_TITLES = arrayOf(
	R.string.title_login,
	R.string.title_register,
	R.string.title_shop,
	R.string.title_profile
	)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context , fm: FragmentManager) :
	FragmentPagerAdapter(fm) {
	
	override fun getItem(position: Int): Fragment {
		// getItem is called to instantiate the fragment for the given page.
		// Return a PlaceholderFragment (defined as a static inner class below).
		return when (position){
			0 -> LoginFragment()
			1 -> RegisterFragment()
			2 -> ShoppingCartFragment()
			else -> ProfileFragment()
		}
	}
	
	override fun getPageTitle(position: Int): CharSequence {
		return context.resources.getString(TAB_TITLES[position])
	}
	
	override fun getCount(): Int {
		// Show 2 total pages.
		return 4
	}
}