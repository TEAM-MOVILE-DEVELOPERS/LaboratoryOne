package com.juancho1037.umadefoods.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.ActivityMainBinding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    
        val navHostFragment: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController = navHostFragment.navController
        val bottomBar = mainBinding.bottomBar
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_fragment, R.id.shopping_cart_fragment, R.id.favorites_fragment, R.id.profile_fragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomBar.setupWithNavController(navController)
    }
}
