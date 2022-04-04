package com.juancho1037.umadefoods.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
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
	private lateinit var navController: NavController
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		mainBinding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(mainBinding.root)
		
		// Inicializar las variables del Navigation
		val navHostFragment: NavHostFragment = supportFragmentManager
			.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
		navController = navHostFragment.navController
//        val navController = findNavController(navHostFragment.id)
		val bottomBar: BottomNavigationView = mainBinding.bottomBar
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		appBarConfiguration = AppBarConfiguration(
			setOf(
				R.id.home_fragment ,
				R.id.shopping_cart_fragment ,
				R.id.favorites_fragment ,
				R.id.profile_fragment
			)
		)
		// Configurar BottomBar
		bottomBar.setupWithNavController(navController)
		
		// Configurar ActionBar con el correcto funcionamiento del botón Arriba
		val toolbar = mainBinding.toolbar
		setSupportActionBar(toolbar)
		toolbar.setupWithNavController(navController , appBarConfiguration)
		// Esconder el bottom y el action bar
		// Tomado de https://stackoverflow.com/a/64022255/12162298
		navController.addOnDestinationChangedListener { _ , destination , _ ->
			if (destination.id == R.id.splash_fragment
				|| destination.id == R.id.login_fragment
				|| destination.id == R.id.register_fragment
			) {
				bottomBar.visibility = View.GONE
				supportActionBar?.hide()
			} else {
				bottomBar.visibility = View.VISIBLE
				supportActionBar?.show()
			}
		}
	}
	
	override fun onBackPressed() {
		when (navController.currentDestination?.id) {
			R.id.home_fragment , R.id.login_fragment                                      -> finish()
			R.id.shopping_cart_fragment , R.id.profile_fragment , R.id.favorites_fragment -> navController.navigate(
				R.id.action_global_home_fragment
			)
			else                                                                          -> navController.popBackStack()
		}
	}
	
	override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val retValue = super.onCreateOptionsMenu(menu)
		// The NavigationView already has these same navigation items, so we only add
		// navigation items to the menu here if there isn't a NavigationView
		menuInflater.inflate(R.menu.overflow_menu , menu)
		return true
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		// Have Navigation UI Handle the item selection
		// Have the NavigationUI look for an action or destination matching the menu
		// item id and navigate there if found.
		// Otherwise, bubble up to the parent.
		return item.onNavDestinationSelected(findNavController(mainBinding.navHostFragment.id))
				|| super.onOptionsItemSelected(item)
	}
	
	
}
