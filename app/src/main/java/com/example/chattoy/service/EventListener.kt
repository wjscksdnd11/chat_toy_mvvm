package com.example.chattoy.service

interface EventListener {

    fun onConnect(vararg args: Any)

    fun onDisconnect(vararg args: Any)

    fun onConnectError(vararg args: Any)

    fun onConnectTimeout(vararg args: Any)

    fun onNewMessage(vararg args: Any)

    fun onUserJoined(vararg args: Any)

    fun onUserLeft(vararg args: Any)

    fun onTyping(vararg args: Any)

    fun onStopTyping(vararg args: Any)
}
