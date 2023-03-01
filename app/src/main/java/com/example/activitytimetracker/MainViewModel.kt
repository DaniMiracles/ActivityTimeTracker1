package com.example.activitytimetracker

class MainViewModel(private val mainModel: MainModel,private val secondsToHours: SecondsToHours) : Observe {


    fun startTrackingTime() {
        callback.post(secondsToHours.map(mainModel.time()))
        mainModel.startTracking()
    }

    fun stopTrackingTime() {
        mainModel.stopTracking()
    }

    fun clear() {
        callback = UIStateCallback.Empty()
    }

    private var callback: UIStateCallback = UIStateCallback.Empty()

    override fun initialize(callback: UIStateCallback) {
        this.callback = callback
    }

}

interface Observe {

    fun initialize(callback: UIStateCallback)
}

interface UIStateCallback {

    fun post(message: String)

    class Empty() : UIStateCallback {
        override fun post(message: String) = Unit

    }

}