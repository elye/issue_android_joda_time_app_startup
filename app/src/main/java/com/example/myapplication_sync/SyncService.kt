package com.example.myapplication_sync

import android.app.Service
import android.content.Intent
import android.os.IBinder

class SyncService: Service() {

    override fun onCreate() {
        super.onCreate()
//        Debug.waitForDebugger()
        Util.getTimeZone("SyncService")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
