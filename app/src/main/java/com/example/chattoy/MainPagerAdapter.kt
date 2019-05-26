package com.example.chattoy

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.chattoy.chat.ChatFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return if (position==0)  ChatFragment.newInstance() else ChatFragment.newInstance()
    }

    override fun getCount(): Int {
        return 2
    }

}