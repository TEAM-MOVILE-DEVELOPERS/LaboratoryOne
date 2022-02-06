package com.juancho1037.umadefoods.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.juancho1037.umadefoods.MainActivity
import com.juancho1037.umadefoods.R
import com.juancho1037.umadefoods.databinding.LoginActivityBinding
import com.juancho1037.umadefoods.ui.register.RegisterActivity


class LoginActivity : AppCompatActivity()
{
    private lateinit var loginBinding: LoginActivityBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)


        loginBinding=LoginActivityBinding.inflate(layoutInflater)

        loginBinding.RegistroTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        setContentView(loginBinding.root)



        val credential = intent.extras
        var emailReceived: String? =""
        var passwordReceived: String?=""

        if (credential != null)
        {
             emailReceived=credential.getString("email")
             passwordReceived=credential.getString("password")
        }

        with(loginBinding){
            loginButton.setOnClickListener{
               val email = userNameTextInputEdit.text.toString()
               val password = passwordTextInputEdit.text.toString()

                if (userNameTextInputEdit.text.toString().isEmpty() || passwordTextInputEdit.text.toString().isEmpty())
                {
                    Toast.makeText(this@LoginActivity, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
                }
                else{

                    if (email==emailReceived && password==passwordReceived && email.isNotEmpty() && password.isNotEmpty())
                    {
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("email", userNameTextInputEdit.text.toString())


                    }
                    else {
                        Toast.makeText(this@LoginActivity, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()

                    }
                }


            }

        }



    }


}