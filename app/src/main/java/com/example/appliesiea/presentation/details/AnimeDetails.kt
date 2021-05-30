package com.example.appliesiea.presentation.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appliesiea.R
import com.example.appliesiea.presentation.api.AnimeDetailsResponse
import com.example.appliesiea.presentation.Singletons
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnimeDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anime_details)

        val message = intent.getStringExtra("EXTRA_MESSAGE")

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val imageTextView = findViewById<ImageView>(R.id.anime_details_image)
        val nameTextView = findViewById<TextView>(R.id.anime_details_name)
        val nameJpTextView = findViewById<TextView>(R.id.anime_details_nameJp)
        val datesTextView = findViewById<TextView>(R.id.anime_details_dates)
        val titleSynopsis = findViewById<TextView>(R.id.anime_details_titleSynopsis)
        val synopsisTextView = findViewById<TextView>(R.id.anime_details_synopsis)

        var isCheck: Boolean = true


        //////////PARTIE APPEL API - ADAPTER ETC///////////////////

        Singletons.animeApi.getAnime(message).enqueue(object : Callback<AnimeDetailsResponse> {
            override fun onResponse(
                call: Call<AnimeDetailsResponse>,
                response: Response<AnimeDetailsResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    actionBar!!.title = response.body()!!.data.attributes.titles.en_jp
                    Picasso.get().load(response.body()!!.data.attributes.posterImage.large).into(
                        imageTextView
                    )
                    nameTextView.text = response.body()!!.data.attributes.titles.en_jp
                    nameJpTextView.text = response.body()!!.data.attributes.titles.ja_jp
                    datesTextView.text =
                        response.body()!!.data.attributes.startDate + " - " + response.body()!!.data.attributes.endDate
                    titleSynopsis.text = getString(R.string.titleSynopsis)
                    synopsisTextView.text = response.body()!!.data.attributes.synopsis
                    synopsisTextView.setOnClickListener {
                        if (isCheck) {
                            synopsisTextView.setMaxLines(1000);
                            isCheck = false;
                        } else {
                            synopsisTextView.setMaxLines(10);
                            isCheck = true;
                        }
                    }

                }
            }

            override fun onFailure(call: Call<AnimeDetailsResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        //////////PARTIE APPEL API - ADAPTER ETC///////////////////

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
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