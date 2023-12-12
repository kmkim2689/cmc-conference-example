package com.practice.conference_example.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.conference_example.core.Resource
import com.practice.conference_example.domain.use_case.GetArrivalInfoUseCase
import com.practice.conference_example.domain.use_case.GetMessageUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map

class ArrivalInfoViewModel(
    private val getArrivalInfoUseCase: GetArrivalInfoUseCase,
    private val getMessageUseCase: GetMessageUseCase
) : ViewModel() {

    val arrivalInfo = getArrivalInfoUseCase.execute("latest").map { arrivalInfo ->
        when (arrivalInfo) {
            is Resource.Loading -> UiState.Loading
            is Resource.Success -> UiState.Success(data = arrivalInfo.data)
            is Resource.Error -> UiState.Error(message = arrivalInfo.message)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UiState.Loading
        )
    }

}