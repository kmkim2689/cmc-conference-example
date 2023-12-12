package com.practice.conference_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.practice.conference_example.data.MockArrivalInfoRepository
import com.practice.conference_example.domain.repository.ArrivalInfoRepository
import com.practice.conference_example.domain.use_case.GetArrivalInfoUseCase
import com.practice.conference_example.domain.use_case.GetMessageUseCase
import com.practice.conference_example.ui.theme.BusArrivalApp
import com.practice.conference_example.ui.view_model.ArrivalInfoViewModel
import com.practice.conference_example.ui.view_model.ArrivalInfoViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: ArrivalInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeViewModel()

        setContent {
            BusArrivalApp {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val data = viewModel.arrivalInfo.collectAsStateWithLifecycle()
                    Column {
                        data.value.data?.map {
                            Text(text = it.toString())
                        }
                    }
                }
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
            viewModel = ViewModelProvider(this@MainActivity, viewModelFactory)
                .get(ArrivalInfoViewModel::class.java)
        }
    }
}
