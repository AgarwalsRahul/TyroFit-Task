package com.notesync.tyrofit.businesss.data.network


sealed class ApiResult<out T> {

    data class Success<out T>(val value: T) : ApiResult<T>()

    data class GenericError(val code: Int? = null, val errorMessage: String? = null) :
        ApiResult<Nothing>()

    data class FirebaseError(val code: String? = null, val errorMessage: String? = null) :
        ApiResult<Nothing>()

    object NetworkError : ApiResult<Nothing>()
}