package com.example.activitytimetracker

import android.content.Context
import android.content.Context.MODE_PRIVATE

class MainModel(
    private val dataSource: DataSource,
    private val now: Now
) {


    private var time: Long = 0

    fun time(): Long {
        return dataSource.getLong(KEY, 0)
    }

    fun startTracking() {
        time = now.time()
    }

    fun stopTracking() {
        val now = now.time()
        val difference = now - time
        val saved = time()
        val newTime = saved + difference
        dataSource.putLong(KEY, newTime)

    }

    companion object {
        const val KEY = "time-key"
    }

}

interface Now {

    fun time(): Long

    class Base() : Now {
        override fun time(): Long = System.currentTimeMillis()
    }
}


interface DataSource {

    fun putLong(key: String, time: Long)

    fun getLong(key: String, default: Long): Long

    class Base(context: Context) : DataSource {
        private val sharedPreferences = context.getSharedPreferences("modelTime", MODE_PRIVATE)

        override fun putLong(key: String, time: Long) {
            sharedPreferences.edit().putLong(key, time).apply()
        }

        override fun getLong(key: String, default: Long): Long {
            return sharedPreferences.getLong(key, default)
        }


    }


}