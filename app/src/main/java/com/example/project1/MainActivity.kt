package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(COOKIE_COUNTER_KEY,0)
        }

        myButton.setOnClickListener {
            counter++
            score.text = counter.toString()
            myImage.dissapear()

        }

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run{
            putInt(COOKIE_COUNTER_KEY, counter)
        }

        super.onSaveInstanceState(outState)

    }

    companion object {
        private const val COOKIE_COUNTER_KEY = "cookieCounterKey"
    }
}
