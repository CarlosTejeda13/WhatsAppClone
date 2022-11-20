package com.example.message.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.message.databinding.ItemUserBinding
import com.example.message.domain.model.User
import com.example.message.ui.common.BaseListViewHolder

class UserListAdapter(
    private val onUserClick: (User) -> Unit,
): ListAdapter<User, BaseListViewHolder<*>>(DiffUtilCallback) {

    private object DiffUtilCallback : DiffUtil.ItemCallback<User>(){
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem == newItem
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*>{
            val itemBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return BindViewHolder(itemBinding)
        }

        override fun onBindViewHolder (holder: BaseListViewHolder<*>, position: Int){
            when(holder){
                is BindViewHolder -> holder.bind(getItem(position), position)
            }
        }

        inner class BindViewHolder(private val binding: ItemUserBinding) : BaseListViewHolder<User>(binding.root){
            override fun bind(item: User, position: Int) = with(binding) {
               /* tvContentTitle.text = item.id
                tvContentDesc.text = item.name
                ivContentIcon.setImageResource(item.image)

                when(item.image){
                    R.drawable.ic_beginner ->mcvTopicParent.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.green_message))
                    R.drawable.ic_intermediate ->mcvTopicParent.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.blue))
                    R.drawable.ic_advance ->mcvTopicParent.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.red))
                } */

                userName.text = item.name
                userImage.setImageResource(item.image)
                userCard.setOnClickListener{ onUserClick.invoke(item) }
        }

    }
}