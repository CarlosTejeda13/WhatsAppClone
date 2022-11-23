package com.example.message.ui.chat

import android.content.Context
import android.content.SharedPreferences.Editor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.navArgs
import com.example.message.R
import com.example.message.data.local.UserHelper
import com.example.message.databinding.FragmentChatBinding
import com.example.message.domain.ext.hideKeyboard
import com.example.message.ui.chats.ChatListAdapter
import com.example.message.ui.chats.ChatsFragment


class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding: FragmentChatBinding
        get() = _binding!!

    private val args: ChatFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onDetach() {
        super.onDetach()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChatBinding.inflate(inflater, container, false)

        setupClickListeners()
        setupUserInformation()
        setupMessageListener()
        return binding.root
    }

    private fun setupClickListeners() {
        binding.backButton.setOnClickListener{activity?.onBackPressed()}
    }

    private fun setupUserInformation(){
        val userToText = UserHelper.usersList.find {
            it.id == args.chatId
        }?: throw Exception("Invalid chat id")
    with(binding){
        chatImage.setImageResource(userToText.image)
        chatName.text = userToText.name
    }
    }

    //Funcion para para escuchar cambios en el inputText
    private fun setupMessageListener(){
        with(binding){
            etMessage.addTextChangedListener {
                llSendMessage.isVisible = it.toString().isNotEmpty()  //llSendMessage sera visible si it no esta vacio
            }

            etMessage.setOnEditorActionListener{ textView, actionId, keyEvent ->
                if(actionId == EditorInfo.IME_ACTION_SEND){
                   hideKeyboard()
                 // handleSendMessage()
                }
                true

            }
        }
    }

}




