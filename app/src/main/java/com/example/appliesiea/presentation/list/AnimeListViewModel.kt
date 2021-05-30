package com.example.appliesiea.presentation.list

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appliesiea.Classes.Anime
import com.example.appliesiea.presentation.Singletons
import com.example.appliesiea.presentation.api.AnimeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeListViewModel: ViewModel() {

    val animeList : MutableLiveData<List<Anime>> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        Singletons.animeApi.getAnimeList().enqueue(object : Callback<AnimeResponse> {
            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                //TODO("not implemented")
            }

            override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val animeResponse: AnimeResponse = response.body()!!
                    animeList.value = animeResponse.data
                }
            }

        })
    }
}