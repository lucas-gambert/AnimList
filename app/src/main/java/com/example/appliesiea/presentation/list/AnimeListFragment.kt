package com.example.appliesiea.presentation.list

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appliesiea.R
import com.example.appliesiea.api.AnimeApi
import com.example.appliesiea.api.AnimeResponse
import kotlinx.android.synthetic.main.fragment_anime_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeListFragment : Fragment(), View.OnClickListener {

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

        val searchText = view.findViewById<EditText>(R.id.searchQuery)
        val searchButton = view.findViewById<ImageButton>(R.id.searchBtn)

        Singletons.animeApi.getAnimeList().enqueue(object: Callback<AnimeResponse>{
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

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.searchBtn->{

                Singletons.animeApi.searchAnime("dbz").enqueue(object: Callback<AnimeResponse> {
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
    }

}