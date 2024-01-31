package com.dhanazam.nota.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object CalendarUtil {

    fun getCurrentDay(): String {
        val sdf = SimpleDateFormat("EEE", Locale.getDefault())
        return sdf.format(Calendar.getInstance().time)
    }

    fun getCurrentTime():String {
        val sdf = SimpleDateFormat("hh:mm", Locale.getDefault())
        return sdf.format(Calendar.getInstance().time)
    }

    fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("dd", Locale.getDefault())
        return sdf.format(Calendar.getInstance().time)
    }

    fun getCurrentMonth(): String {
        val sdf = SimpleDateFormat("MM", Locale.getDefault())
        return sdf.format(Calendar.getInstance().time)
    }
}