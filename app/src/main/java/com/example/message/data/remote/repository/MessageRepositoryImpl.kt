package com.example.message.data.remote.repository

import com.example.message.data.remote.Constants.DEFAULT_NETWORK_ERROR
import com.example.message.domain.model.Message
import com.example.message.domain.repository.MessagesRepository
import com.example.message.util.Resource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore
) : MessagesRepository {


    override suspend fun sendMessage(message: Message): Resource<Unit> {
        return try {
            var isSuccessful=false
            firebaseFirestore.collection(message.chatId)
                .document(message.id)
                .set(message, SetOptions.merge())
                .addOnCompleteListener({isSuccessful == it.isSuccessful})
                .await()

            if (isSuccessful){
                Resource.Success(Unit)
            }else{
                Resource.Error(DEFAULT_NETWORK_ERROR)
            }

        }catch (e: Exception){
            Resource.Error(e.message.toString())
        }
    }

   /* override suspend fun fetchMessageByChat(chatId: String): Resource<List<Message>> {

    } */

}