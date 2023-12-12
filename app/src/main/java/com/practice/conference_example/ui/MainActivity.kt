package com.practice.conference_example.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.practice.conference_example.data.MockArrivalInfoRepository
import com.practice.conference_example.domain.use_case.GetArrivalInfoUseCase
import com.practice.conference_example.domain.use_case.GetMessageUseCase
import com.practice.conference_example.ui.theme.BusArrivalAppTheme
import com.practice.conference_example.ui.view_model.ArrivalInfoViewModel
import com.practice.conference_example.ui.view_model.ArrivalInfoViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: ArrivalInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel()
        setContent {
            val uiState = viewModel.arrivalInfo.collectAsStateWithLifecycle().value

            BusArrivalAppTheme {
                MainScreen(uiState)
            }
        }
    }

    private fun initializeViewModel() {
        val arrivalInfoRepository = MockArrivalInfoRepository()
        arrivalInfoRepository.let {
            val getArrivalInfoUseCase = GetArrivalInfoUseCase(it)
            val getMessageUseCase = GetMessageUseCase(it)
            val viewModelFactory = ArrivalInfoViewModelFactory(
                getArrivalInfoUseCase, getMessageUseCase
            )

            viewModel = ViewModelProvider(
                owner = this, factory = viewModelFactory
            )[ArrivalInfoViewModel::class.java]
        }
    }
}
