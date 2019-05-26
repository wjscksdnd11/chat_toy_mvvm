package com.example.chattoy.data

import com.example.chattoy.data.entities.Message
import com.example.chattoy.service.EventListener
import io.reactivex.Flowable
import java.net.URISyntaxException


public interface DataSource : EventListener {

    @Throws(URISyntaxException::class)
    fun connect(username: String)

    fun disconnect()

    fun sendMessage(message: Message): Flowable<Message>

    fun setEventListener(eventListener: EventListener)
}