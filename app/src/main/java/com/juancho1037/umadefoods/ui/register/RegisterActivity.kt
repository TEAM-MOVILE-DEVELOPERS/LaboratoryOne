package com.juancho1037.umadefoods.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.juancho1037.umadefoods.databinding.ActivityRegisterBinding
import com.juancho1037.umadefoods.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding
    private lateinit var registroViewModel: RegistroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        registroViewModel = ViewModelProvider(this).get(RegistroViewModel::class.java)

        registroViewModel.msgDone.observe(this) { resul ->
            Toast.makeText(this, resul, Toast.LENGTH_SHORT).show()
        }

        registroViewModel.dataValidated.observe(this){result ->
            onMsgDoneSubcibe(result)
        }

        with(registerBinding) {
            registerButton.setOnClickListener {
                registroViewModel.enterDatos(

                    userNameInputText.text.toString(),
                    addressInputText.text.toString(),
                    newEmailInputText.text.toString(),
                    newPasswordInputText.text.toString(),
                    repPasswordInputText.text.toString()
                )
            }
        }
    }

    private fun onMsgDoneSubcibe(result: Boolean?) {

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

    }
}