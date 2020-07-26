package com.egorshustov.threadingtest

import android.os.Handler
import android.os.Looper
import android.util.Log

class ExampleThread : Thread() {

    lateinit var looper: Looper

    lateinit var handler: Handler

    override fun run() {
        super.run()
        Looper.prepare() // this adds a lopper to this background thread and also creates a message queue which are tied together
        looper = Looper.myLooper()!!
        handler =
            ExampleHandler() // Handler can only work for a thread that has a looper or a message queue
        Looper.loop()

        Log.d(TAG, "End of run()")
    }

    companion object {
        private const val TAG = "ExampleThread"
    }
}