package com.juancho1037.umadefoods.ui.register


import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel  : ViewModel()
{
	
	private val msg : MutableLiveData<String> = MutableLiveData()
	val msgDone : LiveData<String> = msg
	
	private val dataValidate : MutableLiveData<Boolean> = MutableLiveData()
	val dataValidated: LiveData<Boolean> = dataValidate
	
	private fun checkEmail(email_: String): Boolean {
		return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()}
	
	fun enterDatos(name: String, adress : String, email: String, password: String, repeatpassword: String) {
		
		if (name.isEmpty() || adress.isEmpty() || email.isEmpty()|| password.isEmpty() || repeatpassword.isEmpty())
		{
			msg.value = "Todos los campos son obligatorios"
		}else{
			if (!checkEmail(email)){
				msg.value = "Formato de e-mail incorrecto."
			}else{
				if (password.length < 6){
					msg.value = "La contraseña debe ser mínimo de 6 dígitos."
				}else{
					if (password != repeatpassword)
					{
						msg.value = "Las contraseñas deben ser iguales"
					}else{
						msg.value = "Pasar al login"
						dataValidate.value=true
						//val intent = Intent(this, LoginActivity::class.java)
						// intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
						//startActivity(intent)
					}
				}
			}
		}
	}
}