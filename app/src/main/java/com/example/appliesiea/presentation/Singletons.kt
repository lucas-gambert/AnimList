package com.example.appliesiea.presentation

import com.example.appliesiea.presentation.api.AnimeApi
import com.example.appliesiea.presentation.AnimeApplication.Companion.context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons {
    companion object{
        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024)

        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()

        val animeApi: AnimeApi = Retrofit.Builder()
            .baseUrl("https://kitsu.io/api/edge/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient)
            .build()
            .create(AnimeApi::class.java)

    }
}