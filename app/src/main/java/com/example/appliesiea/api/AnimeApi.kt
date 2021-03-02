package com.example.appliesiea.api

import retrofit2.Call
import retrofit2.http.GET

interface AnimeApi {
    @GET("anime?page[limit]=20")
    fun getAnimeList(): Call<AnimeResponse>
}