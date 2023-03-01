package com.example.activitytimetracker

interface SecondsToHours {

    fun map(value: Long): String

    class Base : SecondsToHours {


        override fun map(value: Long): String {
            val seconds = value / 1000
            val hours = seconds / 3600
            val minutes = (seconds - hours * 3600) / 60
            val second = (seconds - hours * 3600 - minutes * 60)

            return "$hours:$minutes:$second"

        }

    }
}