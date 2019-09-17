package com.example.project1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var counter: Long = 0
    fun getStore() = getPreferences(Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            counter = savedInstanceState.getLong(COOKIE_COUNTER_KEY,0)
            score.text = counter.toString()
        }

        myButton.setOnClickListener {
            counter++
            score.text = counter.toString()
            myImage.dissapear()

            myButton.text = when(counter){
                1L -> "stop"
                in 2 .. 9 -> myButton.text.toString().plus("!")
                else -> myButton.text
            }

        }

    }

    override fun onPause(){
        super.onPause()
        getStore().edit().putLong(COOKIE_COUNTER_KEY, counter).apply()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run{
            putLong(COOKIE_COUNTER_KEY, counter)
        }

        super.onSaveInstanceState(outState)

    }

    companion object {
        private const val COOKIE_COUNTER_KEY = "cookieCounterKey"
    }
}