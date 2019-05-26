package com.example.chattoy.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.chattoy.data.entities.Friends

@Dao
interface FriendsDao{
    @Query("SELECT * FROM friends ORDER BY friendsName DESC")
    fun getFriends():LiveData<List<Friends>>

}