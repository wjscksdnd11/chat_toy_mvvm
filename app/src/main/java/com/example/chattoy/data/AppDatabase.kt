package com.example.chattoy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.chattoy.data.dao.ChatRoomDao
import com.example.chattoy.data.dao.FriendsDao
import com.example.chattoy.data.dao.MessageDao
import com.example.chattoy.data.entities.ChatRoom
import com.example.chattoy.data.entities.Friends
import com.example.chattoy.data.entities.Message
import com.example.chattoy.util.DateConverter

@Database(entities = [Message::class, ChatRoom::class, Friends::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase :RoomDatabase(){

    abstract fun getMessageDao():MessageDao
    abstract fun getChatRoomDao():ChatRoomDao
    abstract fun getFriendsDAo():FriendsDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "chat.db")
                            .build()
                }
                return INSTANCE!!
            }
        }
    }
}