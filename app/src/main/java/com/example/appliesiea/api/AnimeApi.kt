package com.example.appliesiea.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApi {
    @GET("anime?page[limit]=20")
    fun getAnimeList(): Call<AnimeResponse>

    @GET("anime/{idAnime}")
    fun getAnime(@Path("idAnime") idAnime: String): Call<AnimeDetailsResponse>

    @GET("anime?filter[text]={recherche}")
    fun searchAnime(@Path("recherche") recherche: String): Call<AnimeResponse>
}