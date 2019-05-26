package com.example.chattoy.data

import com.example.chattoy.data.entities.Message
import com.example.chattoy.repository.MessageRepository
import com.example.chattoy.service.EventListener
import io.reactivex.Flowable
import com.example.chattoy.service.EventServiceImpl
import java.net.URISyntaxException


public class RemoteDataSource private constructor(val repo: MessageRepository) : DataSource {


    private val mEventService = EventServiceImpl
    private var mRepoEventListener: EventListener? = null

    companion object {
        @Volatile
        private var INSTANCE: RemoteDataSource? = null
        private val lock = Any()
        fun getInstance(repo: MessageRepository): RemoteDataSource =
                INSTANCE ?: synchronized(lock) {
                    INSTANCE ?: RemoteDataSource(repo)
                }


    }

    @Throws(URISyntaxException::class)
    override fun connect(username: String) {
        mEventService.connect(username)
    }

    override fun disconnect() {
        mEventService.disconnect()
    }

    override fun sendMessage(message: Message): Flowable<Message> {
        return mEventService.sendMessage(message)
    }

    override fun setEventListener(eventListener: EventListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnect(vararg args: Any) {
        mRepoEventListener?.onConnect(args)
    }

    override fun onDisconnect(vararg args: Any) {
        mRepoEventListener?.onDisconnect(args);
    }

    override fun onConnectError(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectTimeout(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNewMessage(vararg args: Any) {
        mRepoEventListener?.onNewMessage(args);
    }

    override fun onUserJoined(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUserLeft(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTyping(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStopTyping(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}