package com.example.chattoy.service

import com.example.chattoy.data.entities.Message
import io.reactivex.Flowable
import java.net.URISyntaxException


interface EventService{
    @Throws(URISyntaxException::class)
    fun connect(userId: String)

    fun disconnect()

    fun sendMessage(message: Message): Flowable<Message>

    fun setEventListener(eventListener: EventListener)

}