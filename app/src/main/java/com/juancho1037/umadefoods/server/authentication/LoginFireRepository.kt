package com.juancho1037.umadefoods.server.authentication

import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class LoginFireRepository {
    private val auth: FirebaseAuth = Firebase.auth

    suspend fun signInFirebase(email: String, password: String): String?{

        var data: String? = ""
        try{
            val result = auth.signInWithEmailAndPassword(email, password).await()
            data = auth.currentUser
            data  = result.user?.uid
        } catch (e: FirebaseAuthException){
            Log.d("errorRegister",e.localizedMessage)
            data = e.localizedMessage
        }
        return data


            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("signInWithEmail:success")
                    val user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}

