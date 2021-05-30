package com.example.appliesiea.presentation.list

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appliesiea.R
import com.example.appliesiea.presentation.list.Classes.Anime
import com.squareup.picasso.Picasso
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class AnimeAdapter(private var dataSet: List<Anime>) :
    RecyclerView.Adapter<AnimeAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView
        val rateTextView: TextView
        var id: Int = 0


        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.anime_name)
            rateTextView = view.findViewById(R.id.anime_rate)
            imageView = view.findViewById(R.id.anime_image)

            //listener sur une ligne
            view.setOnClickListener {
                val intent = Intent(view.context, AnimeDetails::class.java).apply {
                    putExtra("EXTRA_MESSAGE", id.toString())
                }
                view.context.startActivity(intent)
            }
        }
    }

    fun updateList(list: List<Anime>) {
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.anime_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val anime = dataSet[position]

        viewHolder.textView.text = anime.attributes.titles.en_jp
        viewHolder.rateTextView.text = "Note : " + anime.attributes.averageRating
        viewHolder.id = anime.id

        if(anime.attributes.posterImage != null){
            Picasso.get().load(anime.attributes.posterImage.small).into(viewHolder.imageView)
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

