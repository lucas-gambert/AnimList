package com.example.appliesiea

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appliesiea.api.AnimeApi
import com.example.appliesiea.presentation.list.AnimeAdapter
import com.example.appliesiea.presentation.list.AnimeListFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    /*private lateinit var recyclerView: RecyclerView
    private val adapter = AnimeAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val search = menu.findItem(R.id.search)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = "Search"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext, query, Toast.LENGTH_SHORT).show()

                /*recyclerView = view.findViewById(R.id.anime_recyclerview)
                recyclerView.apply {
                    layoutManager = this@AnimeListFragment.layoutManager
                    adapter = this@AnimeListFragment.adapter
                }*/

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://kitsu.io/api/edge/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val animeApi: AnimeApi = retrofit.create(AnimeApi::class.java)
                val txt: String = "dbz"


                /*animeApi.searchAnime(txt).enqueue(object: Callback<AnimeResponse> {
                    override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                        if(response.isSuccessful && response.body() != null){
                            val animeResponse : AnimeResponse = response.body()!!
                            //adapter.updateList(animeResponse.data)
                        }
                    }

                    override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })*/



                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

}

