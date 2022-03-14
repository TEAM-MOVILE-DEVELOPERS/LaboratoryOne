package com.juancho1037.umadefoods.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.ActivityMainBinding
import com.juancho1037.umadefoods.ui.home.cooks_list.CooksListFragment
import com.juancho1037.umadefoods.ui.home.dishes_list.DishesListFragment
import com.juancho1037.umadefoods.ui.register.RegisterFragment
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
                R.id.dishesListFragment   -> {
                    replaceFragment(DishesListFragment.newInstance() , FRAGMENT_FIRST)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.cooksListFragment -> {
                    replaceFragment(
                        CooksListFragment.newInstance() ,
                        FRAGMENT_SECOND
                    )
                    return@OnNavigationItemSelectedListener true
                }
                R.id.shoppingCartFragment -> {
                    replaceFragment(
                        ShoppingCartFragment.newInstance() ,
                        FRAGMENT_VIEWPAGER
                    )
                    return@OnNavigationItemSelectedListener true
                }
                R.id.registerFragment -> {
                    replaceFragment(
                        RegisterFragment.newInstance() ,
                        FRAGMENT_VIEWPAGER
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
        ft.add(R.id.fragment_container , DishesListFragment.newInstance() , FRAGMENT_FIRST)
            .commit()
    }
    
    private fun replaceFragment(newFragment: Fragment , tag: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container , newFragment , tag)
            .commit()
    }
    
    companion object {
        const val FRAGMENT_VIEWPAGER = "FRAGMENT_VIEWPAGER"
        const val FRAGMENT_FIRST = "FRAGMENT_FIRST"
        const val FRAGMENT_SECOND = "FRAGMENT_SECOND"
    }
    
}
/*
        val navView: BottomNavigationView = mainBinding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_bottom)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.dishesListFragment, R.id.cooksListFragment, R.id.shoppingCartFragment, R.id.registerFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
*/
