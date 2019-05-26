package com.example.chattoy.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.chattoy.util.DateConverter
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity(tableName = "messages")
data class Message(@PrimaryKey var messageId:String,
                   var userId: String,
                   var userName: String,
                   var message: String,
                   @NotNull  var roomId:String,
                   var createAt: Date) {
    var isRead: Boolean = false
}