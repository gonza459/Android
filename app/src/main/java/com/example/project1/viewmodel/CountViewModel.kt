package com.example.project1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.project1.CountRepository

class CountViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CountRepository(application.applicationContext)

    fun getUserCount(name: String) = repository.getUserCount(name)

    fun setUserCount(name: String, count: Long) = repository.setUserCount(name,count)
}
