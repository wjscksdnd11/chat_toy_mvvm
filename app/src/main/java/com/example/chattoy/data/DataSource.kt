package com.example.chattoy.data

import com.example.chattoy.data.entities.ChatRoom
import com.example.chattoy.data.entities.Message
import com.example.chattoy.service.EventListener
import io.reactivex.Flowable
import java.net.URISyntaxException


interface DataSource : EventListener {

    @Throws(URISyntaxException::class)
    fun connect(userId: String)

    fun disconnect()

    fun sendMessage(message: Message): Flowable<Message>

    fun setEventListener(eventListener: EventListener)

    fun loadMessage(callback: LoadMessageCallback )

    fun loadChatRooms(userID:String,callback: LoadChatRoomCallback)

    fun getMessages():Flowable<List<Message>>
    interface LoadMessageCallback {
        fun onSuccess(message: List<Message>)
        fun onFail()
    }
    fun saveMessage(message:Message)

    interface LoadChatRoomCallback{
        fun onSuccess(rooms:List<ChatRoom>)
        fun onFail()
    }

}