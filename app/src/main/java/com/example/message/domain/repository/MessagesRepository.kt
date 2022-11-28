package com.example.message.domain.repository

import com.example.message.domain.model.Message
import com.example.message.util.Resource

interface MessagesRepository {

suspend fun sendMessage(message: Message): Resource<Unit>
//suspend fun fetchMessageByChat(chatId: String): Resource<List<Message>>

}