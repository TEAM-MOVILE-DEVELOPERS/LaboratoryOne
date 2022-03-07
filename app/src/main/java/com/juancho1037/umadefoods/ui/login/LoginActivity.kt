package com.juancho1037.umadefoods.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.juancho1037.umadefoods.databinding.ActivityLoginBinding
import com.juancho1037.umadefoods.ui.register.RegisterActivity


class LoginActivity : AppCompatActivity()
{
    private lateinit var loginBinding: ActivityLoginBinding
    private  lateinit var loginViewModel: LoginViewModel
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        loginBinding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

       loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        loginBinding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginViewModel.msgDone.observe(this,{resul->
            Toast.makeText(this,resul, Toast.LENGTH_SHORT).show()
        })

        with(loginBinding){
            loginButton.setOnClickListener{
                loginViewModel.ingresoDatos(
                    emailInputText.text.toString(),
                    passwordInputText.text.toString()
                )
            }
        }
    }
    
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
        Toast.makeText(this,"Bye Bye",Toast.LENGTH_SHORT).show()
    }
    
}
