package com.example.message.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.message.ui.calls.CallsFragment
import com.example.message.ui.chats.ChatsFragment
import com.example.message.ui.social.SocialFragment

class DashboardPageAdapter(fragment: Fragment): FragmentStateAdapter(fragment){
    override fun getItemCount(): Int =3

    override fun createFragment(position: Int): Fragment {
      return when(position){
          0 -> {ChatsFragment()}
          1 -> {SocialFragment()}
          2 -> {CallsFragment()}
          else -> throw IllegalArgumentException("Invalid fragment position , max valuae 2")
      }

    }
}