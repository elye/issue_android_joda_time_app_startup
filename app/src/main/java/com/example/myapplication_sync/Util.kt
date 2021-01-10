package com.example.myapplication_sync

import android.app.Application
import android.util.Log
import java.util.Calendar
import org.joda.time.DateTimeZone

object Util {
    const val DEBUG_TRACKING = "TrackDebug"

    fun getTimeZone(className: String) {
        Log.d(DEBUG_TRACKING, "$className ${Application.getProcessName()} ${Thread.currentThread()}")
        try {
            val x = DateTimeZone.forTimeZone(Calendar.getInstance().timeZone)
            Log.d(DEBUG_TRACKING, "- $className $x")
        } catch (e: Exception) {
            Log.d(DEBUG_TRACKING, "- $className ${e.localizedMessage}")
        }
    }
}
