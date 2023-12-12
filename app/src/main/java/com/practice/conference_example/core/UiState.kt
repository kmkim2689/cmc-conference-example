package com.practice.conference_example.core

sealed class UiState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val errorMessage: String? = null
) {
    class Loading<T> : UiState<T>(isLoading = true)
    class Success<T>(data: T?) : UiState<T>(isLoading = false, data = data)
    class Error<T>(errorMessage: String) : UiState<T>(errorMessage = errorMessage)
}