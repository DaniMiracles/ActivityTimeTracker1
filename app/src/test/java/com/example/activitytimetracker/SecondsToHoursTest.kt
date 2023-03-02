package com.example.activitytimetracker

import org.junit.Assert.*
import org.junit.Test

class SecondsToHoursTest{

    @Test
    fun test_for_seconds(){
        val map = SecondsToHours.Base()
        val actual = map.map(2000 * 5)
        val expected = "0:0:10"
        assertEquals(expected, actual)
    }

    @Test
    fun test_for_minutes(){
        val map = SecondsToHours.Base()
        val actual = map.map(1000 * 75)
        val expected = "0:1:15"
        assertEquals(expected, actual)
    }

    @Test
    fun test_for_hours(){
        val map = SecondsToHours.Base()
        val actual = map.map(1000 * 3860)
        val expected = "1:4:20"
        assertEquals(expected, actual)
    }
}