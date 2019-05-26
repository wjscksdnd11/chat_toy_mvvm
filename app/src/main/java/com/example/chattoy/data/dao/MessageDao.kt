package com.example.chattoy.data.dao

import android.os.Message
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.chattoy.data.entities.ChatRoom

@Dao
interface MessageDao {
    @Query("SELECT * FROM messages WHERE roomId = :roomId ORDER BY datetime(createAt) DESC")
    fun getMessages(roomId:String):LiveData<List<Message>>

}