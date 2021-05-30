package com.example.appliesiea.presentation.list

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appliesiea.R
import com.example.appliesiea.presentation.api.AnimeResponse
import kotlinx.android.synthetic.main.fragment_anime_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.appliesiea.Classes.Anime
import com.example.appliesiea.presentation.Singletons
import org.w3c.dom.Text


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loader: ProgressBar

    private val adapter = AnimeAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    private val viewModel: AnimeListViewModel by viewModels()

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
        loader = view.findViewById(R.id.animeLoader)
        val error = view.findViewById<TextView>(R.id.animeError)

        val searchText = view.findViewById<EditText>(R.id.searchQuery)
        val searchButton = view.findViewById<ImageButton>(R.id.searchBtn)

        searchButton.setOnClickListener {
            if(searchText.text.toString() == ""){
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
            }else{
                Singletons.animeApi.searchAnime(searchText.text.toString()).enqueue(object: Callback<AnimeResponse> {
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

        viewModel.animeList.observe(viewLifecycleOwner, Observer { animeModel ->
            loader.isVisible = animeModel is AnimeLoader
            error.isVisible = animeModel is AnimeError
                if(animeModel is AnimeSuccess) {
                    adapter.updateList(animeModel.animeList)
                }
        })

    }

}