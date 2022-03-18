package com.juancho1037.umadefoods.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.ActivityMainBinding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val toolbar = mainBinding.toolbar
        setSupportActionBar(toolbar)
        val navHostFragment : NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController : NavController = navHostFragment.navController
//        val navController = findNavController(navHostFragment.id)
        val bottomBar  : BottomNavigationView = mainBinding.bottomBar
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_fragment, R.id.shopping_cart_fragment, R.id.favorites_fragment, R.id.profile_fragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomBar.setupWithNavController(navController)
    }
    
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(mainBinding.navHostFragment.id).navigateUp(appBarConfiguration)
    }
    
}
