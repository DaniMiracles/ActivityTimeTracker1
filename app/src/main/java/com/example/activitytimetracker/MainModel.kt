package com.example.activitytimetracker

import android.content.Context
import android.content.Context.MODE_PRIVATE

interface MainModel {
    fun time(): Long
    fun startTracking()
    fun stopTracking()


class Base(
    private val dataSource: DataSource,
    private val now: Now
) : MainModel {


    private var time: Long = 0

    override fun time(): Long {
        return dataSource.getLong(KEY, 0)
    }

    override fun startTracking() {
        time = now.time()
    }

    override fun stopTracking() {
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