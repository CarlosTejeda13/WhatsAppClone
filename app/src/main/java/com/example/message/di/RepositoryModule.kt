package com.example.message.di

import com.example.message.data.remote.repository.MessageRepositoryImpl
import com.example.message.domain.repository.MessagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMessagesRepository(
        messagesRepository: MessageRepositoryImpl
    ):MessagesRepository
}