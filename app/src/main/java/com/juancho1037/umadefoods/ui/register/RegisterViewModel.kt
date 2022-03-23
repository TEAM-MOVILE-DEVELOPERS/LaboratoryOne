package com.juancho1037.umadefoods.ui.register


import android.util.Log
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterViewModel  : ViewModel()
{
	/* Instancia de Firebase*/
	private lateinit var auth: FirebaseAuth

	private val msg : MutableLiveData<String> = MutableLiveData()
	val msgDone : LiveData<String> = msg
	
	private val dataValidate : MutableLiveData<Boolean> = MutableLiveData()
	val dataValidated: LiveData<Boolean> = dataValidate
	
	private fun checkEmailFormat(email_: String): Boolean {
		return PatternsCompat.EMAIL_ADDRESS.matcher(email_).matches()}
	
	fun enterDatos(name: String, adress : String, email: String, password: String, repeatpassword: String) {

		auth = Firebase.auth

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
						auth.createUserWithEmailAndPassword(email, password)
							.addOnCompleteListener { task->
								if(task.isSuccessful){
									Log.d("Register","createUserWithEmail:success")
									//createUser(auth.currentUser?.uid,email)
									//onBackPressed()
								} else{
									Log.w("Register","createUserWithEmail:failure",task.exception)
									/*
									Toast.makeText(
										baseContext,task.exception?.message.toString(),
										Toast.LENGTH_SHORT
									).show()
									*/
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