package com.example.myapplication_sync

import java.util.Calendar
import org.joda.time.DateTimeZone

object DeviceTimeZone {
    fun get(): DateTimeZone {
        return DateTimeZone.forTimeZone(Calendar.getInstance().timeZone)
    }
}
