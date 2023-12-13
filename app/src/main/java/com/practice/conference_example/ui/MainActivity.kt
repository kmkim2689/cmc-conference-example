package com.practice.conference_example.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.practice.conference_example.core.Event
import com.practice.conference_example.data.MockArrivalInfoRepository
import com.practice.conference_example.domain.use_case.GetArrivalInfoUseCase
import com.practice.conference_example.domain.use_case.GetMessageUseCase
import com.practice.conference_example.ui.theme.BusArrivalAppTheme
import com.practice.conference_example.ui.view_model.ArrivalInfoViewModel
import com.practice.conference_example.ui.view_model.ArrivalInfoViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ArrivalInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel()
        setContent {
            val scope = rememberCoroutineScope()
            val arrivalInfoState = viewModel.arrivalInfo.collectAsStateWithLifecycle().value
            LaunchedEffect(key1 = true) {
                showToast()
            }

            BusArrivalAppTheme {
                MainScreen(arrivalInfoState)
            }
        }
    }

    private suspend fun showToast() {
        viewModel.message.collect { messageEvent ->
            if (messageEvent is Event.Success) {
                Toast.makeText(this@MainActivity, messageEvent.data, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, messageEvent.errorMessage, Toast.LENGTH_SHORT).show()
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
