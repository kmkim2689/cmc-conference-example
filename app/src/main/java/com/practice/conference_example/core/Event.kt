package com.practice.conference_example.core

sealed class Event<T>(
    val data: T? = null,
    val errorMessage: String? = null
) {
    class Success<T>(data: T?) : Event<T>(data = data)
    class Error<T>(errorMessage: String) : Event<T>(errorMessage = errorMessage)
}