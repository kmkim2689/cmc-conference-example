package com.practice.conference_example.domain.use_case

import com.practice.conference_example.core.Resource
import com.practice.conference_example.data.ArrivalInfo
import com.practice.conference_example.domain.repository.ArrivalInfoRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetArrivalInfoUseCase(
    private val repository: ArrivalInfoRepository
) {
    fun execute(sortBy: String) = flow {
        try {
            emit(Resource.Loading())
            delay(2000)
            emit(Resource.Success(repository.getArrivalInfo(sortBy)))
        } catch (e: Exception) {
            if (e is CancellationException) {
                throw e
            }
            emit(Resource.Error(e.localizedMessage ?: "unexpected error"))
        }
    }
}