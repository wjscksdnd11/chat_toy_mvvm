package com.example.chattoy.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rooms")
data class ChatRoom(@PrimaryKey var roomId:String, var lastMessage:String, var lastDate:String)