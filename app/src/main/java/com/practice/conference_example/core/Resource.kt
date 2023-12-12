package com.practice.conference_example.core

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(data: T?, message: String?) : Resource<T>(data = data, message = message)
}