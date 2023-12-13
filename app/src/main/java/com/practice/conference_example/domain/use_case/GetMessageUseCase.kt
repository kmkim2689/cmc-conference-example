package com.practice.conference_example.domain.use_case

import com.practice.conference_example.core.Resource
import com.practice.conference_example.data.ArrivalInfo
import com.practice.conference_example.domain.repository.ArrivalInfoRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

class GetMessageUseCase(
    private val repository: ArrivalInfoRepository
) {
    fun execute() = flow<Resource<String>> {
        try {
            emitArrivalMessage()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            emit(Resource.Error(e.localizedMessage ?: "unexpected error"))
        }
    }

    private suspend fun FlowCollector<Resource<String>>.emitArrivalMessage() {
        while (true) {
            repository.getArrivalMessage()?.let {
                emit(Resource.Success(it))
            } ?: emit(Resource.Error("No Information"))

            delay(10000)
        }
    }
}