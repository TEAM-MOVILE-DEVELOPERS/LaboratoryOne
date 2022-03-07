package com.juancho1037.umadefoods.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juancho1037.umadefoods.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var mainBinding: ActivityMainBinding
    private var emailReceived: String? = ""
    private var passwordReceived: String? = ""
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        /*val credentials = intent.extras
        if (credentials != null){
            credentials.getString("email").also{emailReceived = it}
            credentials.getString("password").also{passwordReceived = it}
        }
        val userLogged: TextView = findViewById(R.id.email_text_view)
        "Acceso exitoso:\n $emailReceived".also { userLogged.text = it }
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK + Intent.FLAG_ACTIVITY_CLEAR_TASK
        Toast.makeText(this,"Bye Bye",Toast.LENGTH_SHORT).show()
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
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        intent.putExtra("email" , emailReceived)
        intent.putExtra("password" , passwordReceived)
        startActivity(intent)
    }*/
    }
}