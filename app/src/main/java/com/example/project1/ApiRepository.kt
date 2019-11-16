package com.example.project1

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.project1.model.Gif
import com.example.project1.model.GifResponse
import com.example.project1.Network.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiRepository(context: Context) {
    private val giphyService: Api = Api.create(context)

    fun getRandomGif(tag: String): LiveData<Gif> {
        val data = MutableLiveData<Gif>()

        giphyService.getRandomGif(tag, "pg", API_KEY).enqueue(object : Callback<GifResponse> {
            override fun onResponse(call: Call<GifResponse>, response: Response<GifResponse>) {
                data.value = response.body()?.data
            }

            override fun onFailure(call: Call<GifResponse>, t: Throwable) {
                //nothing
            }
        })

        return data
    }

    companion object {
        private const val API_KEY = "YdwxPNt3JQbgS8rKBDs3hawt4BhmmwHW"
    }
}