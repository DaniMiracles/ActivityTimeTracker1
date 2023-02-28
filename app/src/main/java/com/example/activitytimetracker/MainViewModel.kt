package com.example.activitytimetracker

class MainViewModel(private val mainModel: MainModel) : Observe {


    fun startTrackingTime() {
        callback.post(mainModel.time().toString())
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