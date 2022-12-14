package com.example.message.ui.chats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.message.databinding.ItemChatBinding
import com.example.message.domain.model.Chat
import com.example.message.ui.common.BaseListViewHolder

class ChatListAdapter (
    private val onChatClick: (Chat) -> Unit,
): ListAdapter<Chat, BaseListViewHolder<*>>(DiffUtilCallback) {

    private object DiffUtilCallback : DiffUtil.ItemCallback<Chat>(){
        override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean = oldItem == newItem
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*> {
        val itemBinding = ItemChatBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BindViewHolder(itemBinding)
    }

    override fun onBindViewHolder (holder: BaseListViewHolder<*>, position: Int){
        when(holder){
            is BindViewHolder -> holder.bind(getItem(position), position)
        }
    }

    inner class BindViewHolder(private val binding: ItemChatBinding): BaseListViewHolder<Chat>(binding.root){
        override fun bind(item: Chat, position: Int) = with(binding) {
            /* tvContentTitle.text = item.id
             tvContentDesc.text = item.name
             ivContentIcon.setImageResource(item.image)

             when(item.image){
                 R.drawable.ic_beginner ->mcvTopicParent.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.green_message))
                 R.drawable.ic_intermediate ->mcvTopicParent.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.blue))
                 R.drawable.ic_advance ->mcvTopicParent.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.red))
             } */

            chatName.text = item.userName
            chatImage.setImageResource(item.userImage)

            chatParent.setOnClickListener{ onChatClick.invoke(item) }
        }

    }
}