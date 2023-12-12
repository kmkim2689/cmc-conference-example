package com.practice.conference_example.data

import com.practice.conference_example.domain.repository.ArrivalInfoRepository
import kotlin.random.Random

class MockArrivalInfoRepository : ArrivalInfoRepository {

    private val arrivalInfoItems = listOf<ArrivalInfo>(
        ArrivalInfo(1, Bus.AIRPORT, 5, 3),
        ArrivalInfo(2, Bus.COMMUNITY, 6, 4),
        ArrivalInfo(3, Bus.SEATS, 7, 5),
        ArrivalInfo(4, Bus.SEATS, 8, 6),
        ArrivalInfo(5, Bus.AIRPORT, 9, 7),
        ArrivalInfo(6, Bus.COMMUNITY, 11, 8),
        ArrivalInfo(7, Bus.SEATS, 13, 9),
        ArrivalInfo(8, Bus.COMMUNITY, 15, 10),
        ArrivalInfo(9, Bus.COMMUNITY, 16, 15),
        ArrivalInfo(10, Bus.AIRPORT, 17, 16),
    )

    override suspend fun getArrivalInfo(sortBy: String): List<ArrivalInfo> = arrivalInfoItems

    override suspend fun getArrivalMessage(): String? =
        if (Random.nextBoolean()) "The bus is arriving in a moment" else null
}