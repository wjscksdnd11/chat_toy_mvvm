package com.example.chattoy.data

import android.content.Context
import android.preference.PreferenceManager

object  User{
    fun getUserId(context: Context):String?{
       return PreferenceManager.getDefaultSharedPreferences(context).getString("userId",null)
    }

}