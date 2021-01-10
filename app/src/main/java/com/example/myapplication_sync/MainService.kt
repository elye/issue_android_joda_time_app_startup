package com.example.myapplication_sync

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MainService : Service() {
    override fun onCreate() {
        super.onCreate()
        Util.getTimeZone("MainService")
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}