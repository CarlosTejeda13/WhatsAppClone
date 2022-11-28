package com.example.message.ui.chat

import androidx.lifecycle.*
import com.example.message.domain.model.Message
import com.example.message.domain.usecase.FetchMessageRealTimeUseCase
import com.example.message.domain.usecase.SendMessageUseCase
import com.example.message.util.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase,
    private val fetchMessageRealTimeUseCase: FetchMessageRealTimeUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _messageListState: MutableLiveData<Resource<List<Message>>> = MutableLiveData()
    val messageListState: LiveData<Resource<List<Message>>>
        get() = _messageListState

    private val _sendMessageState: MutableLiveData<Resource<Unit>> = MutableLiveData()
    val sendMessageState: LiveData<Resource<Unit>>
        get() = _sendMessageState

    init {
        val chatId = savedStateHandle.get<String>("chatId")

        if (!chatId.isNullOrEmpty()) {
            getMessages(chatId = chatId)
        }
    }

    private fun getMessages(chatId: String) {
        viewModelScope.launch {
            fetchMessageRealTimeUseCase(chatId).onEach{
                _messageListState.value = it
            }.launchIn(viewModelScope)
        }
    }

    fun sendMessage(message: Message){
        viewModelScope.launch {
            sendMessageUseCase(message).onEach {
                _sendMessageState.value= it
            }.launchIn(viewModelScope)

        }
    }
}