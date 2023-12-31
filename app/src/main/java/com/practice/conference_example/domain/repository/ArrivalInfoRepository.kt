package com.practice.conference_example.domain.repository

import com.practice.conference_example.data.ArrivalInfo

interface ArrivalInfoRepository {
    suspend fun getArrivalInfo(sortBy: String): List<ArrivalInfo>

    suspend fun getArrivalMessage(): String?
}