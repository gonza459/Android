package com.example.project1.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.project1.R
import com.example.project1.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var countViewModel: CountViewModel
    private var flowerCounter: Long = 0
    private fun getUserName() = intent.extras?.get("username").toString().toLowerCase(Locale.US)

 //   fun getStore() = getPreferences(Context.MODE_PRIVATE)
 //   var COOKIE_COUNTER_KEY = "cookieCounterKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount((getUserName())).observe(this,
            androidx.lifecycle.Observer { updateCounter(it) })

        myButton.setOnClickListener {
            flowerCounter++
            countViewModel.setUserCount(getUserName(), flowerCounter + 1)
        }

    }

    private fun updateCounter(count:Long){
        flowerCounter = count
        score.text = "Score: ${flowerCounter.toString()}"
    }

   // override fun onPause(){
    //    super.onPause()
    //    getStore().edit().putLong(COOKIE_COUNTER_KEY, counter).apply()
   // }

    // override fun onSaveInstanceState(outState: Bundle?) {
   //     outState?.run{
    //        putLong(COOKIE_COUNTER_KEY, counter)
     //   }

    //    super.onSaveInstanceState(outState)
//
  //  }

}
