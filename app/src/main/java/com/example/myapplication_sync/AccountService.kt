package com.example.myapplication_sync

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import org.joda.time.DateTimeZone
import java.lang.Exception
import java.util.*

class AccountService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}
