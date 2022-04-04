package com.juancho1037.umadefoods.ui.register


import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.juancho1037.umadefoods.server.authentication.RegFireRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterViewModel  : ViewModel()
{
	private var repository = RegFireRepository()

	private val msg : MutableLiveData<String> = MutableLiveData()
	val msgDone : LiveData<String> = msg
	
	private val dataValidate : MutableLiveData<Boolean> = MutableLiveData()
	val dataValidated: LiveData<Boolean> = dataValidate

	private val errorMsg: MutableLiveData<String?> = MutableLiveData()
	val errorMsgDone: LiveData<String?> = errorMsg

	private val registerSucess: MutableLiveData<Boolean> = MutableLiveData()
	val registerSucessDone: LiveData<Boolean> = registerSucess
	
	private fun checkEmailFormat(email_: String): Boolean {
		return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()}
	
	fun enterDatos(name: String, adress : String, email: String, password: String, repeatpassword: String) {

		if (name.isEmpty() || adress.isEmpty() || email.isEmpty()|| password.isEmpty() || repeatpassword.isEmpty())
		{
			msg.value = "Todos los campos son obligatorios"
		}else{
			if (!checkEmailFormat(email)){
				msg.value = "Formato de e-mail incorrecto."
			}else{
				if (password.length < 6){
					msg.value = "La contraseña debe ser mínimo de 6 dígitos."
				}else{
					if (password != repeatpassword)
					{
						msg.value = "Las contraseñas deben ser iguales"
					}else{
						GlobalScope.launch(Dispatchers.IO){
							val result = repository.userRegister(email,password)
							if(result == "User Created Succesfull"){
								registerSucess.postValue(true)
							}else{
								//errorMsg.postValue(result)
								if(result == "The email address is already in use by another account.")
									errorMsg.postValue("Ya existe una cuenta con ese correo electrónico")
								else
									if(result == "The given password is invalid. [ Password should be at least 6 characters ]")
										errorMsg.postValue("La contraseña debe tener mínimo 6 dígitos")
							}
						}

						//msg.value = "Pasar al login"
						//dataValidate.value=true
						//val intent = Intent(this, LoginActivity::class.java)
						// intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
						//startActivity(intent)
					}
				}
			}
		}
	}

	/*
	private fun createUser(uid: String?, email: String){
		//val db = Firebase.firestore
		val user = User(id = uid,email = email)

	}
	*/
}