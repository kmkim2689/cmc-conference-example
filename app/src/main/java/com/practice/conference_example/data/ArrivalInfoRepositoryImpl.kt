package com.practice.conference_example.data

import com.practice.conference_example.domain.ArrivalInfoRepository
import kotlin.random.Random

class ArrivalInfoRepositoryImpl : ArrivalInfoRepository {

    private val arrivalInfoItems = listOf<ArrivalInfo>(
        ArrivalInfo(Bus.AIRPORT, 5, 3),
        ArrivalInfo(Bus.COMMUNITY, 6, 4),
        ArrivalInfo(Bus.SEATS, 7, 5),
        ArrivalInfo(Bus.SEATS, 8, 6),
        ArrivalInfo(Bus.AIRPORT, 9, 7),
        ArrivalInfo(Bus.COMMUNITY, 11, 8),
        ArrivalInfo(Bus.SEATS, 13, 9),
        ArrivalInfo(Bus.COMMUNITY, 15, 10),
        ArrivalInfo(Bus.COMMUNITY, 16, 15),
        ArrivalInfo(Bus.AIRPORT, 17, 16),
    )

    override suspend fun getArrivalInfo(sortBy: String): List<ArrivalInfo> = arrivalInfoItems

    override suspend fun getArrivalMessage(): String? =
        if (Random.nextBoolean()) "The bus is arriving in a moment" else null
}