package com.example.activitytimetracker

import android.content.Context
import android.content.Context.MODE_PRIVATE

class MainModel(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("modelTime", MODE_PRIVATE)

    private var time: Long = 0

    fun time(): Long {
        return sharedPreferences.getLong(KEY, 0)
    }

    fun startTracking() {
        time = System.currentTimeMillis()
    }

    fun stopTracking() {
        val now = System.currentTimeMillis()
        val difference = time - now
        val saved = sharedPreferences.getLong(KEY,0)
        val newTime =  saved + difference
        sharedPreferences.edit().putLong(KEY,newTime).apply()

    }

    companion object {
        const val KEY = "time-key"
    }

}