package com.practice.conference_example.domain.use_case

import com.practice.conference_example.data.ArrivalInfo
import com.practice.conference_example.domain.repository.ArrivalInfoRepository
import kotlinx.coroutines.flow.flow

class GetArrivalInfoUseCase(
    private val repository: ArrivalInfoRepository
) {
    fun execute(sortBy: String) = flow<List<ArrivalInfo>> {

    }
}