package com.juancho1037.umadefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.juancho1037.umadefoods.databinding.ActivityMainBinding
import com.juancho1037.umadefoods.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding : ActivityMainBinding

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this,"Bye Bye",Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_sign_out -> goToLoginActivity()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToLoginActivity() {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}