package com.example.chattoy.service

import android.util.Log
import androidx.annotation.NonNull
import com.example.chattoy.data.entities.Message
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter

object EventServiceImpl:EventService{

    private val TAG = EventServiceImpl::class.java.simpleName
    private var mUserId: String? = null
    private const val SOCKET_URL = "socket url "
    private const val EVENT_CONNECT = Socket.EVENT_CONNECT
    private const val EVENT_DISCONNECT = Socket.EVENT_DISCONNECT
    private const val EVENT_NEW_MESSAGE = "new message"
    private var mEventListener: EventListener? = null
    private val mSocket: Socket? = IO.socket(SOCKET_URL)

    private val onConnect = Emitter.Listener { args ->
        Log.i(TAG, "call: onConnect")
        mSocket?.emit("add user", mUserId)
        mEventListener?.onConnect(args)
    }

    // On disconnect listener
    private val onDisconnect = Emitter.Listener { args ->
        Log.i(TAG, "call: onDisconnect")
        mEventListener?.onDisconnect(args)
    }

    // On new message listener
    private val onNewMessage = Emitter.Listener { args ->
        Log.i(TAG, "call: onNewMessage")
        mEventListener?.onNewMessage(args)
    }

    override fun connect(userId: String) {
        mUserId = userId
        mSocket?.on(EVENT_CONNECT,onConnect)
        mSocket?.on(EVENT_DISCONNECT, onDisconnect)
        mSocket?.on(EVENT_NEW_MESSAGE, onNewMessage)

        mSocket?.connect()

    }

    override fun disconnect() {

        mSocket?.disconnect()
    }

    override fun sendMessage(@NonNull message: Message): Flowable<Message> {
        return Flowable.create({ emitter ->
            mSocket?.emit(EVENT_NEW_MESSAGE,message.message)
            emitter.onNext(message)
        },BackpressureStrategy.BUFFER)
    }

    override fun setEventListener(eventListener: EventListener) {
        mEventListener = eventListener
    }


}