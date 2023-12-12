package com.practice.conference_example.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.conference_example.data.ArrivalInfo

@Composable
fun ArrivalInfoList(arrivalInfoItems: List<ArrivalInfo>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                textAlign = TextAlign.Center,
                text = "Bus Arrival Info",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            ArrivalInfoHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp)
            )
        }

        items(
            items = arrivalInfoItems,
            key = { arrivalInfoItem -> arrivalInfoItem.route }
        ) {
            ArrivalInfoItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp),
                arrivalInfo = it
            )
        }
    }
}