package com.example.appliesiea.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApi {
    @GET("anime?page[limit]=20")
    fun getAnimeList(): Call<AnimeResponse>

    @GET("anime/{idAnime}")
    fun getAnime(@Path("idAnime") idAnime: String): Call<AnimeDetailsResponse>

    @GET("anime?")
    fun searchAnime(@Query("filter[text]") recherche: String): Call<AnimeResponse>
}