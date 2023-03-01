package com.example.activitytimetracker

import junit.framework.Assert.assertEquals
import org.junit.Test


class MainModelTest {

    @Test
    fun test() {
        val dataSource = FakeDataSource()
        val fakeNow = FakeNow()
        val model = MainModel(dataSource,fakeNow)

        model.startTracking()
        fakeNow.time = 10_000
        model.stopTracking()
        assertEquals(10_000,dataSource.getLong("",0))

    }
}

private class FakeNow() : Now {
    var time: Long = 0L
    override fun time(): Long {
        return time
    }
}

private class FakeDataSource: DataSource{
    var value:Long = 0

    override fun putLong(key: String, time: Long) {
        value = time
    }

    override fun getLong(key: String, default: Long): Long {
       return value
    }


}

