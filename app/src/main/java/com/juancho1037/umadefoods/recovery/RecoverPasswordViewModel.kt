package com.juancho1037.umadefoods.recovery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juancho1037.umadefoods.utils.ResourceRemote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class RecoverPasswordViewModel: ViewModel(),  CoroutineScope{

    override val coroutineContext: CoroutineContext = Dispatchers.IO

    private val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val  onIsLoading: LiveData<Boolean> = isLoading

    private val isRecoveryPassword = MutableLiveData<ResourceRemote<String>?>()
    val onRecoveryPassword: MutableLiveData<ResourceRemote<String>?> = isRecoveryPassword

    fun recoveryPassword(email: String){
        viewModelScope.launch(coroutineContext){
            isLoading.postValue(true)
        }
    }
}