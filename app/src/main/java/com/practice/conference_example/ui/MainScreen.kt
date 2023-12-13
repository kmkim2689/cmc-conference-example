package com.practice.conference_example.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.practice.conference_example.core.UiState
import com.practice.conference_example.data.ArrivalInfo
import com.practice.conference_example.ui.component.ArrivalInfoList
import com.practice.conference_example.ui.component.ProgressIndicator
import kotlinx.coroutines.Job

@Composable
fun MainScreen(
    arrivalInfo: UiState<List<ArrivalInfo>>
) {
    val arrivalInfoItems = arrivalInfo.data ?: emptyList()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (arrivalInfo is UiState.Loading) {
            ProgressIndicator()
        } else {
            ArrivalInfoList(arrivalInfoItems)
        }
    }
}