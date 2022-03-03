package com.juancho1037.umadefoods.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.juancho1037.umadefoods.MainActivity
import com.juancho1037.umadefoods.databinding.ActivityLoginBinding
import com.juancho1037.umadefoods.ui.register.RegisterActivity


class LoginActivity : AppCompatActivity()
{
    private lateinit var loginBinding: ActivityLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        loginBinding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        supportActionBar?.hide()
        val credential = intent.extras
        var emailReceived: String? =""
        var passwordReceived: String? =""
        
        if (credential != null)
        {
            emailReceived=credential.getString("email")
            passwordReceived=credential.getString("password")
        }

        loginBinding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        with(loginBinding){
            loginButton.setOnClickListener{
               val email = emailInputText.text.toString()
               val password = passwordInputText.text.toString()

                if (email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(this@LoginActivity, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                }
                else{

                    if (email==emailReceived && password==passwordReceived)
                    {
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        intent.putExtra("email",emailReceived)
                        intent.putExtra("password", passwordReceived)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this@LoginActivity, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
        Toast.makeText(this,"Bye Bye",Toast.LENGTH_SHORT).show()
    }
    
}
