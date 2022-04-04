package com.juancho1037.umadefoods.server.authentication

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class RegFireRepository() {

    private val auth: FirebaseAuth = Firebase.auth

    suspend fun userRegister(email: String, password: String): String?{
        var data: String? = ""
        try{
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            data  = result.user?.uid
        } catch (e:FirebaseAuthException){
            Log.d("errorRegister",e.localizedMessage)
            data = e.localizedMessage
        }
        return data
    }
}