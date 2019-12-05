package com.example.project1.util

import android.app.IntentService
import android.content.Intent

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        intent?.apply {
            when (intent.action) {
                ACTION_SEND_TEST_MESSAGE -> {
                    val message = getStringExtra(EXTRA_MESSAGE)
                    println(message)
                }
            }
        }
    }

    companion object {
        const val ACTION_SEND_TEST_MESSAGE = "Come Back!"
        const val EXTRA_MESSAGE = "EXTRA_MESSAGE"
    }

}