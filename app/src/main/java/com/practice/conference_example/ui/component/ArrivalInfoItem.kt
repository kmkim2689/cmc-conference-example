package com.practice.conference_example.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.practice.conference_example.data.ArrivalInfo
import com.practice.conference_example.data.Bus
import com.practice.conference_example.ui.theme.BusArrivalAppTheme

@Composable
fun ArrivalInfoItem(
    modifier: Modifier = Modifier,
    arrivalInfo: ArrivalInfo
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(percent = 10))
            .border(width = 2.dp, color = Color.Gray)
            .background(color = Color.LightGray)
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(modifier = Modifier.weight(3f), text = arrivalInfo.busType.toString())
        Text(modifier = Modifier.weight(1f), text = arrivalInfo.route.toString())
        Text(modifier = Modifier.weight(2f), text = "${arrivalInfo.stopsLeft} stops")
        Text(modifier = Modifier.weight(2f), text = "${arrivalInfo.minutesLeft} minutes")
    }
}

@Composable
fun ArrivalInfoHeader(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(percent = 10))
            .background(color = Color.Yellow)
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(modifier = Modifier.weight(3f), text = "Sort", fontWeight = FontWeight.Bold)
        Text(modifier = Modifier.weight(1.5f), text = "Route", fontWeight = FontWeight.Bold)
        Text(modifier = Modifier.weight(2f), text = "Stops\nLeft", fontWeight = FontWeight.Bold)
        Text(modifier = Modifier.weight(2f), text = "Minutes\nLeft", fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun ArrivalInfoItemPreview() {
    ArrivalInfoItem(
        modifier = Modifier.fillMaxWidth(),
        arrivalInfo = ArrivalInfo(1, Bus.SEATS, 1, 3)
    )
}