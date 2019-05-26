package com.example.chattoy.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Friends")
data class Friends (var friendsId:String, var friendsName:String){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
    var isConnectiong:Boolean = false
}