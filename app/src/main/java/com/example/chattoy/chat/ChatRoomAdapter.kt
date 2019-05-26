package com.example.chattoy.chat

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chattoy.R

class ChatRoomAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class HeaderViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    class ChatRoomViewholder(itemView:View ): RecyclerView.ViewHolder(itemView)
    class EmptyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

}