package com.example.message.domain.usecase

import com.example.message.domain.model.Message
import com.example.message.domain.repository.MessagesRepository
import com.example.message.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val repository: MessagesRepository,
) {
    suspend operator fun invoke(message: Message): Flow<Resource<Unit>> = flow {

        emit(Resource.Loading)

        val networkRequest = repository.sendMessage(
            message = message
        )
        when(networkRequest){
            is Resource.Success -> emit(Resource.Success(Unit))
            is Resource.Error -> emit(Resource.Error(networkRequest.message))
            else ->Resource.Finished
        }
    }
}