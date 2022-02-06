package com.juancho1037.umadefoods.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.juancho1037.umadefoods.databinding.LoginActivityBinding
import com.juancho1037.umadefoods.databinding.RegisterActivityBinding
import com.juancho1037.umadefoods.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
  
  private lateinit var registerBinding: RegisterActivityBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = RegisterActivityBinding.inflate(layoutInflater)


        setContentView(registerBinding.root)

        with(registerBinding){
            registerButton.setOnClickListener{
                val complete_name = fullnameEditText.text.toString()
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val repeatPassword = repeatPassordEditText.text.toString()

                if (password == repeatPassword){
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    intent.putExtra("email",email)
                    intent.putExtra("password",password)
                    startActivity(intent)

                }else
                    Toast.makeText(applicationContext, "Las contraseñas deben ser iguales", Toast.LENGTH_SHORT).show()
            }
        }


    }
}