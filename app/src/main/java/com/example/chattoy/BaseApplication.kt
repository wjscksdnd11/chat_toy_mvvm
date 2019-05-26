package com.example.chattoy

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Observer to detect if the app is in background or foreground.
        val lifeCycleObserver = AppLifeCyclerObserver(applicationContext)

        // Adding the above observer to process lifecycle
        ProcessLifecycleOwner.get()
                .lifecycle
                .addObserver(lifeCycleObserver)
    }
}