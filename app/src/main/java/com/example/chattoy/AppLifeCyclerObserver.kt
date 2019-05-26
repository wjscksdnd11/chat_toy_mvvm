package com.example.chattoy

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.example.chattoy.data.User
import java.net.URISyntaxException
import com.example.chattoy.service.EventServiceImpl



class AppLifeCyclerObserver(context:Context) :LifecycleObserver{
    val mContext: Context = context

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onEnterForeGround(){
       try {
           User.getUserId(mContext)?.let {
               EventServiceImpl.connect(it)
           }
       } catch (e: URISyntaxException){

       }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onEnterBackground() {
        EventServiceImpl.disconnect()
    }
}