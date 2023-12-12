package com.practice.conference_example.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.conference_example.data.ArrivalInfo
import com.practice.conference_example.domain.use_case.GetArrivalInfoUseCase
import com.practice.conference_example.domain.use_case.GetMessageUseCase

class ArrivalInfoViewModelFactory(
    private val getArrivalInfoUseCase: GetArrivalInfoUseCase,
    private val getMessageUseCase: GetMessageUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArrivalInfoViewModel::class.java)) {
            return ArrivalInfoViewModel(
                getArrivalInfoUseCase,
                getMessageUseCase
            ) as T
        } else throw IllegalArgumentException("unknown model class")
    }
}