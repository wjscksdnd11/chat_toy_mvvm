package com.example.chattoy.data

import com.example.chattoy.data.entities.Message
import com.example.chattoy.repository.MessageRepository
import com.example.chattoy.service.EventListener
import io.reactivex.Flowable


public class LocalDataSource private constructor(val repo: MessageRepository) : DataSource {
    override fun connect(userId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disconnect() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendMessage(message: Message): Flowable<Message> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setEventListener(eventListener: EventListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadMessage(callback: DataSource.LoadMessageCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadChatRooms(userID: String, callback: DataSource.LoadChatRoomCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnect(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDisconnect(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectError(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectTimeout(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNewMessage(vararg args: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
