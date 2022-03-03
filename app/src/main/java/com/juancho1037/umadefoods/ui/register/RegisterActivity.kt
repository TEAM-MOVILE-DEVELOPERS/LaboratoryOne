package com.juancho1037.umadefoods.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.PatternsCompat
import com.juancho1037.umadefoods.databinding.ActivityRegisterBinding
import com.juancho1037.umadefoods.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
  private lateinit var registerBinding: ActivityRegisterBinding

      private fun checkEmail(email_: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()
      }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)
        supportActionBar?.hide()

        with(registerBinding) {
            registerButton.setOnClickListener {
                // val complete_name = fullnameEditText.text.toString()
                // val address_name = adressEditText.text.toString()
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val repeatPassword = repPasswordInputText.text.toString()
                if (!checkEmail(email)) {
                    Toast.makeText(
                        this@RegisterActivity ,
                        "Formato de e-mail incorrecto." ,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (password.length < 6) {
                        Toast.makeText(
                            this@RegisterActivity,
                            "La contraseña debe ser mínimo de 6 dígitos" ,
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        if (password != repeatPassword) {
                            Toast.makeText(
                                applicationContext ,
                                "Las contraseñas deben ser iguales" ,
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val intent = Intent(this@RegisterActivity , LoginActivity::class.java)
                            intent.putExtra("email" , email)
                            intent.putExtra("password" , password)
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }
}