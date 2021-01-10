package com.example.myapplication_sync

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.example.myapplication_sync.MainApplication.Companion.DEBUG_TRACKING
import org.joda.time.DateTimeZone
import java.util.*

class SyncService: Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d(DEBUG_TRACKING, "SyncService onCreate")
        try {
            Log.d(DEBUG_TRACKING, "SyncService ${DateTimeZone.forTimeZone(Calendar.getInstance().timeZone)}")
        } catch (e: Exception) {
            Log.d(DEBUG_TRACKING, "SyncService ${e.localizedMessage}")
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
