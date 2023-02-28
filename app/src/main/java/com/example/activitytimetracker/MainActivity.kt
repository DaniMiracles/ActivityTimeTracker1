package com.example.activitytimetracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Miracles","onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         textView = findViewById<TextView>(R.id.tv_mainAct)
        viewModel = (application as ActivityTimeTrackerApp).viewModel

        viewModel.initialize(object : UIStateCallback{
            override fun post(message: String) {
                textView.text = message
            }
        })

    }

    override fun onResume() {
        super.onResume()
        Log.d("Miracles","onResume")
        viewModel.startTrackingTime()
    }

    override fun onPause() {
        super.onPause()
        Log.d("Miracles","onPause")
        viewModel.stopTrackingTime()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Miracles","onDestroy")
       // viewModel.clear()
       
    }
}