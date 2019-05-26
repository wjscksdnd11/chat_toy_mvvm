package com.example.chattoy.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.chattoy.data.entities.ChatRoom

@Dao
interface ChatRoomDao{

    @Query("SELECT * FROM rooms ORDER BY datetime(lastDate) DESC")
    fun getChatRooms(): LiveData<List<ChatRoom>>
}