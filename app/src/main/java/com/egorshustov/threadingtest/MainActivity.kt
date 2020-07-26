package com.egorshustov.threadingtest

import android.os.Bundle
import android.os.Message
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val exampleThread = ExampleThread()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startThread(view: View) {
        exampleThread.start()
    }

    fun stopThread(view: View) {
        exampleThread.looper.quit() // or exampleThread.handler.looper.quit()
    }

    fun taskA(view: View) {
        val message = Message.obtain().apply { what = ExampleHandler.TASK_A }
        exampleThread.handler.sendMessage(message)

        /*Handler(exampleThread.looper).post {
            for (i in 0 until 5) {
                Log.d(TAG, "run(): ${Thread.currentThread().name}: $i")
                Thread.sleep(1000)
            }
        }*/
    }

    fun taskB(view: View) {
        val message = Message.obtain().apply { what = ExampleHandler.TASK_B }
        exampleThread.handler.sendMessage(message)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}