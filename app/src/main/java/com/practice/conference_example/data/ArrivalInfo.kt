package com.practice.conference_example.data

data class ArrivalInfo(
    val route: Int,
    val busType: Bus,
    val minutesLeft: Int,
    val stopsLeft: Int
)

enum class Bus {
    COMMUNITY,
    SEATS,
    AIRPORT
}