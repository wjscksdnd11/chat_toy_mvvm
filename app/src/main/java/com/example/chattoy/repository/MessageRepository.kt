package com.example.chattoy.repository

import com.example.chattoy.data.DataSource
import com.example.chattoy.data.LocalDataSource
import com.example.chattoy.data.RemoteDataSource
import com.example.chattoy.data.entities.Message
import com.example.chattoy.service.EventListener
import io.reactivex.Flowable

class MessageRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) : DataSource {

    var cacheIsDirty =false

    override fun saveMessage(message: Message) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun getMessages(): Flowable<List<Message>> {
        return localDataSource
                .getMessages()
                .doOnComplete{
                    cacheIsDirty = false
                }
    }

    init {
        remoteDataSource.setEventListener(this)
    }

    override fun loadMessage(callback: DataSource.LoadMessageCallback) {
        localDataSource.loadMessage(callback)
    }

    override fun loadChatRooms(userID: String, callback: DataSource.LoadChatRoomCallback) {
        localDataSource.loadChatRooms(userID, callback)
    }


    override fun connect(userId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disconnect() {
        remoteDataSource.disconnect()
    }

    override fun sendMessage(message: Message): Flowable<Message> {
        return remoteDataSource.sendMessage(message)
    }

    override fun setEventListener(eventListener: EventListener) {
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