package com.egorshustov.threadingtest

import android.os.Handler
import android.os.Message
import android.util.Log

class ExampleHandler : Handler() {

    override fun handleMessage(msg: Message) {
        when (msg.what) {
            TASK_A -> Log.d(TAG, "TASK_A executed")
            TASK_B -> Log.d(TAG, "TASK_B executed")
        }
    }

    companion object {
        const val TASK_A = 1
        const val TASK_B = 2
        private const val TAG = "ExampleHandler"
    }
}