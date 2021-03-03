package com.example.appliesiea.presentation.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appliesiea.R
import com.example.appliesiea.api.AnimeApi
import com.example.appliesiea.api.AnimeDetailsResponse
import com.example.appliesiea.api.AnimeResponse
import com.example.appliesiea.presentation.list.Classes.Anime
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class AnimeDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_details)

        val message = intent.getStringExtra("EXTRA_MESSAGE")

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title = message

        val idTextView = findViewById<TextView>(R.id.anime_details_id)

        //////////PARTIE APPEL API - ADAPTER ETC///////////////////
        val retrofit = Retrofit.Builder()
            .baseUrl("https://kitsu.io/api/edge/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: AnimeApi = retrofit.create(AnimeApi::class.java)

        service.getAnime(message).enqueue(object: Callback<AnimeDetailsResponse> {
            override fun onResponse(call: Call<AnimeDetailsResponse>, response: Response<AnimeDetailsResponse>) {
                if(response.isSuccessful && response.body() != null){
                    //actionBar!!.title = response.body()!!.data.id.toString()
                    idTextView.text = response.body()!!.data.id.toString()
                }
            }
            override fun onFailure(call: Call<AnimeDetailsResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        //////////PARTIE APPEL API - ADAPTER ETC///////////////////

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

}