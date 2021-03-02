package com.example.appliesiea.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appliesiea.R
import com.example.appliesiea.api.AnimeApi
import com.example.appliesiea.api.AnimeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = AnimeAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.anime_recyclerview)
        recyclerView.apply {
            layoutManager = this@AnimeListFragment.layoutManager
            adapter = this@AnimeListFragment.adapter
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://kitsu.io/api/edge/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val animeApi: AnimeApi = retrofit.create(AnimeApi::class.java)

        animeApi.getAnimeList().enqueue(object: Callback<AnimeResponse>{
            override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val animeResponse : AnimeResponse = response.body()!!
                    adapter.updateList(animeResponse.data)
                }
            }

            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}