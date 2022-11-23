package com.example.message.domain.model

import androidx.annotation.DrawableRes

data class Chat(
    @DrawableRes val userImage : Int,
    val userName : String,
    val id: String
)
