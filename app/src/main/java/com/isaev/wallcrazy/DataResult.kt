package com.isaev.wallcrazy

sealed class DataResult<out T: Any> {
    data class Success<T: Any>(val data: T) : DataResult<T>()
    data class Failure(val exception: Exception) : DataResult<Nothing>()
    object Loading : DataResult<Nothing>()
}
