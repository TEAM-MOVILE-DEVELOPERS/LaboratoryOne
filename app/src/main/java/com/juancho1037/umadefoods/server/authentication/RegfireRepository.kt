package com.juancho1037.umadefoods.server.authentication

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegfireRepository {

    private val auth: FirebaseAuth = Firebase.auth

    suspend fun userRegister(email: String, password: String): String?{
        return try{
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            result.user?.iud
        } catch (e:FirebaseAuthException){
            Log.d("errorRegister",e.localizedMessage)
            e.localizedMessage
        }catch (e:FirebaseAuthException){
            e.localizedMessage
        }
    }
}