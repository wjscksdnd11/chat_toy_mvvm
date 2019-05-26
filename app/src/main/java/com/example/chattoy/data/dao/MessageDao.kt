package com.example.chattoy.data.dao

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.chattoy.data.entities.Message

@Dao
interface MessageDao {
    @Query("SELECT * FROM messages WHERE roomId = :roomId ORDER BY datetime(createAt) DESC")
    fun getMessages(roomId:String):LiveData<List<Message>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMessage(@NonNull message: Message)

    @Update
    fun updateRead(@NonNull message:Message)
}