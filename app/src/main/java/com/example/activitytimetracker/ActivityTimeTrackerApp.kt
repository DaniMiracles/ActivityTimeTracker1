package com.example.activitytimetracker

import android.app.Application
import android.util.Log

class ActivityTimeTrackerApp : Application() {


    lateinit var viewModel: MainViewModel
    override fun onCreate() {
        super.onCreate()
        Log.d("Miracles", "onCreateViewModel")
        viewModel = MainViewModel(MainModel(DataSource.Base(this), Now.Base()),SecondsToHours.Base())
    }
}