package com.example.message.data.local

import com.example.message.R
import com.example.message.domain.model.Chat
import com.example.message.domain.model.User

object UserHelper {
    val usersList = listOf(
        User(
            id= "1",
            image = R.drawable.asset_denis,
            name="Dennis"
        ),
        User(
            id= "2",
            image = R.drawable.asset_jhonie,
            name="Jhonie"
        ),
        User(
            id= "3",
            image = R.drawable.asset_luis,
            name="Luis Mtz"
        ),
        User(
            id= "4",
            image = R.drawable.asset_sofia,
            name="Sofia"
        ),
        User(
            id= "5",
            image = R.drawable.asset_mario_down,
            name="Mario Domm"
        ),
        User(
            id= "6",
            image = R.drawable.asset_luna,
            name="Luna"
        ),
        User(
            id= "7",
            image = R.drawable.asset_lucas,
            name="Lucas"
        ),
        User(
            id= "8",
            image = R.drawable.asset_stefanni,
            name="Stefanni"
        ),
        User(
            id= "9",
            image = R.drawable.asset_melissa,
            name="Melissa"
        ),
        User(
            id= "10",
            image = R.drawable.asset_bryan,
            name="Bryan "
        ),
    )

    val chatList = listOf(
        Chat(
            id = "1",
            userImage = R.drawable.asset_denis,
            userName = "Dennis"
        ),
        Chat(
            id= "2",
            userImage = R.drawable.asset_jhonie,
            userName="Jhonie"
        ),
        Chat(
            id= "3",
            userImage = R.drawable.asset_luis,
            userName="Luis Mtz"
        ),
        Chat(
            id= "4",
            userImage = R.drawable.asset_sofia,
            userName="Sofia"
        ),
        Chat(
            id= "5",
            userImage = R.drawable.asset_mario_down,
            userName="Mario Domm"
        ),
        Chat(
            id= "6",
            userImage = R.drawable.asset_luna,
            userName="Luna"
        ),
        Chat(
            id= "7",
            userImage = R.drawable.asset_lucas,
            userName="Lucas"
        ),
        Chat(
            id= "8",
            userImage = R.drawable.asset_stefanni,
            userName="Stefanni"
        ),
        Chat(
            id= "9",
            userImage = R.drawable.asset_melissa,
            userName="Melissa"
        ),
        Chat(
            id= "10",
            userImage = R.drawable.asset_bryan,
            userName="Bryan "
        ),
    )
}