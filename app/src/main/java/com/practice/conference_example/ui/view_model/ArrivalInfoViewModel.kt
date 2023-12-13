package com.practice.conference_example.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.conference_example.core.Event
import com.practice.conference_example.core.Resource
import com.practice.conference_example.core.UiState
import com.practice.conference_example.domain.use_case.GetArrivalInfoUseCase
import com.practice.conference_example.domain.use_case.GetMessageUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn

class ArrivalInfoViewModel(
    private val getArrivalInfoUseCase: GetArrivalInfoUseCase,
    private val getMessageUseCase: GetMessageUseCase
) : ViewModel() {

    val arrivalInfo = getArrivalInfoUseCase.execute("latest").map { arrivalInfoItem ->
        when (arrivalInfoItem) {
            is Resource.Loading -> UiState.Loading()
            is Resource.Success -> UiState.Success(data = arrivalInfoItem.data)
            is Resource.Error -> UiState.Error(errorMessage = arrivalInfoItem.message!!)
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiState.Loading()
    )

    val message = getMessageUseCase.execute().map { messageContent ->
        when (messageContent) {
            is Resource.Success -> Event.Success(data = messageContent.data)
            is Resource.Error -> Event.Error(errorMessage = messageContent.message!!)
            else -> Event.Error(errorMessage = "unexpected error")
        }
    }.shareIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        replay = 1
    )
}