package com.example.project1.view

import android.content.Context
import android.icu.util.Calendar
import android.icu.util.Calendar.getInstance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.project1.model.Gif
import com.example.project1.R
import com.example.project1.util.AlarmManager
import com.example.project1.viewmodel.CountViewModel
import com.example.project1.viewmodel.GifViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.atomic.LongAdder
import java.util.*

class MainActivity : AppCompatActivity() {

    //initialized the counter view model counter without needing an intial value
    private lateinit var countViewModel: CountViewModel
    private lateinit var gifViewModel: GifViewModel
    private var counter: Long = 0

    //initializing function to take string entered from the login
    private fun getUserName() = intent.extras?.get("username").toString().toLowerCase(Locale.US)


    //gets the info from countViewModel and updates the counter from the count of the view model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = getInstance()
        calendar.add(Calendar.SECOND, 10)
        AlarmManager.setAlarm(applicationContext, calendar.timeInMillis, "Come Back!")

        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)
        countViewModel.getUserCount((getUserName())).observe(this,
            androidx.lifecycle.Observer { updateCounter(it) })

        gifViewModel = ViewModelProviders.of(this).get(GifViewModel::class.java)
        gifViewModel.getRandomGif("android").observe(this,
            androidx.lifecycle.Observer { loadGif(it) })

        //initializes counter to be used for changing flower type
        var flowerCounter = counter


        //For when button is clicked, do these conditions
        myButton.setOnClickListener {
            //increase counter
            counter++


            //Will be code for when button is clicked, each click will increase flower image size
            //val layoutparams = flower.getLayoutParams() as RelativeLayout.LayoutParams

            //layoutparams.width += 20
            //layoutparams.height += 20


            //flower.setLayoutParams(layoutparams)

           // for(i in 1..5 ){
             //   if (i == 1 or 2 or 3 or 4 or 5){

               // }else{

                //}
                //}


            //every 5 clicks, the flower image changes
            if(counter == flowerCounter + 5) {
                var randomInteger = (1..4).shuffled().first()
                if (randomInteger == 1) {
                    flower.setImageResource(R.drawable.red_flower)
                    flowerCounter += 5
                } else if (randomInteger == 2) {
                    flower.setImageResource(R.drawable.yellow_flower)
                    flowerCounter += 5
                } else if (randomInteger == 3) {
                    flower.setImageResource(R.drawable.orange_flower)
                    flowerCounter += 5
                } else if (randomInteger == 4) {
                    flower.setImageResource(R.drawable.blue_flower)
                    flowerCounter += 5
                }
            }

            //stores the user and counter set to the user account
            countViewModel.setUserCount(getUserName(), counter)

        }

    }

    //updates the counter on the screen
    private fun updateCounter(count:Long){
        counter = count
        score.text = "Score: ${counter.toString()}"
    }

    private fun loadGif(gif: Gif){
        Glide.with(this)
            .load(gif.url)
            .into(image)

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
