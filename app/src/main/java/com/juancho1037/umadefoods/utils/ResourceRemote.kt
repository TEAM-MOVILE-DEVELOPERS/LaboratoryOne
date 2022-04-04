package com.juancho1037.umadefoods.utils


sealed class ResourceRemote<T>(
    var data: T? = null,
    var message: String? = null,
    var status: Status? = null,
    var errorCode: Int? = null
){
    //used
    class Success<T>(data: T): ResourceRemote<T>(data = data, status = Status.Success)
    class Loading<T>(message: String = ""):ResourceRemote<T>(message = message, status = Status.Loading)

    class Error<T>(
        errorCode: Int? = null,
        message: String? = null,
    ): ResourceRemote<T>(errorCode = errorCode, message = message, status = Status.Error)

    class Completed<T> : ResourceRemote<T>()
}