package com.example.chattoy.service

import com.example.chattoy.data.Message
import io.reactivex.Flowable
import java.net.URISyntaxException
import java.util.*


interface EventService{
    @Throws(URISyntaxException::class)
    fun connect(username: String)

    fun disconnect()

    fun sendMessage(message: Message): Flowable<Message>

    fun setEventListener(eventListener: EventListener)

}