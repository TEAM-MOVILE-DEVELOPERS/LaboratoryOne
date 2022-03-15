package com.juancho1037.umadefoods.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.ActivityMainBinding
import com.juancho1037.umadefoods.ui.favorites.FavoritesFragment
import com.juancho1037.umadefoods.ui.home.HomeFragment
import com.juancho1037.umadefoods.ui.profile.ProfileFragment
import com.juancho1037.umadefoods.ui.shopping_cart.ShoppingCartFragment

/*
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.juancho1037.umadefoods.R
*/

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.homeFragment   -> {
                    replaceFragment(
                        HomeFragment.newInstance() ,
                        FRAGMENT_HOME
                    )
                    return@OnNavigationItemSelectedListener true
                }
                R.id.shoppingCartFragment -> {
                    replaceFragment(
                        ShoppingCartFragment.newInstance() ,
                        FRAGMENT_SHOPPING_CART
                    )
                    return@OnNavigationItemSelectedListener true
                }
                R.id.favoritesFragment -> {
                    replaceFragment(
                        FavoritesFragment.newInstance() ,
                        FRAGMENT_FAVORITES
                    )
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profileFragment -> {
                    replaceFragment(
                        ProfileFragment.newInstance() ,
                        FRAGMENT_PROFILE
                    )
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }*/
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val navigation : BottomNavigationView = mainBinding.navView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fragment_container , HomeFragment.newInstance() , FRAGMENT_HOME)
            .commit()
    }
    
    private fun replaceFragment(newFragment: Fragment , tag: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container , newFragment , tag)
            .commit()
    }
    
    companion object {
        const val FRAGMENT_HOME = "FRAGMENT_HOME"
        const val FRAGMENT_SHOPPING_CART = "FRAGMENT_SHOPPING_CART"
        const val FRAGMENT_FAVORITES = "FRAGMENT_FAVORITES"
        const val FRAGMENT_PROFILE = "FRAGMENT_PROFILE"
    }
    
}
/*      Para usar con el binding
        val navView: BottomNavigationView = mainBinding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_bottom)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.dishesListFragment, R.id.cooksListFragment, R.id.shoppingCartFragment, R.id.registerFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
*/
