package com.practice.conference_example.ui

import android.icu.text.IDNA.Info
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.practice.conference_example.core.UiState
import com.practice.conference_example.data.ArrivalInfo
import com.practice.conference_example.ui.component.ArrivalInfoHeader
import com.practice.conference_example.ui.component.ArrivalInfoItem
import com.practice.conference_example.ui.component.ArrivalInfoList
import com.practice.conference_example.ui.component.ProgressIndicator

@Composable
fun MainScreen(
    uiState: UiState<List<ArrivalInfo>>
) {
    val arrivalInfoItems = uiState.data ?: emptyList()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (uiState is UiState.Loading) {
            ProgressIndicator()
        } else {
            ArrivalInfoList(arrivalInfoItems)
        }
    }
}