package com.egorshustov.threadingtest

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainHandler = Handler()

    @Volatile
    private var stopThread = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startThread(view: View) {
        stopThread = false
        Thread {
            for (i in 0 until 10) {
                if (stopThread) return@Thread
                if (i == 5) {
                    //mainHandler.post { button_start_thread.text = "50%" }
                    //Handler(Looper.getMainLooper()).post { button_start_thread.text = "50%" }
                    //button_start_thread.post { button_start_thread.text = "50%" }
                    runOnUiThread { button_start_thread.text = "50%" }
                }
                Log.d(TAG, "startThread ${Thread.currentThread().name}: $i")
                Thread.sleep(1000)
            }
        }.start()
    }

    fun stopThread(view: View) {
        stopThread = true
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}