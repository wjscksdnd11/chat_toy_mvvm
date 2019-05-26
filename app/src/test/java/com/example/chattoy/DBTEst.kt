package com.example.chattoy

import android.util.Log
import androidx.room.Room
import com.example.chattoy.data.AppDatabase
import com.example.chattoy.data.dao.MessageDao
import com.example.chattoy.data.entities.Message
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.*

//@RunWith(AndroidJUnit4::class)
class DBTEst {
    lateinit var db:AppDatabase
    lateinit var messageDao:MessageDao
    @Before
    @Throws(Exception::class)
    fun start(){
//        val appContext = InstrumentationRegistry
//        db = Room.inMemoryDatabaseBuilder(appContext,AppDatabase::class.java).build()
//        messageDao = db.getMessageDao()
    }

    @Test
    fun testInsert_many(){
        for (i in 1..10000) {
            messageDao.addMessage(Message(i.toString(),"other","test","just","1",createAt = Date()))
            Log.i("dbtest", i.toString())

        }
        assert(true)

    }
    @After
    @Throws(IOException::class)
    fun end() {
        Log.i("dbtest", "테스트 종료")
        db.close()
    }

}