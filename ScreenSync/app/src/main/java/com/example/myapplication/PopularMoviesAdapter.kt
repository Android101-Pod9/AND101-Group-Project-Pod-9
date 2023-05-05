package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList

class PopularMoviesAdapter (private val posterList: List<String>,private val movieNameList: List<String>): RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val moviePoster: ImageView
        val nameTextView: TextView
        val addButton : ImageButton
        init {
            // Find our RecyclerView item's ImageView for future use
            moviePoster = view.findViewById(R.id.imageView)
            nameTextView = view.findViewById(R.id.movieName)
            addButton = view.findViewById(R.id.add_watchlist)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_movie_setup, parent, false)
        Log.d("create", "CharacterList ${posterList}")
        return ViewHolder(view)
    }
    override fun getItemCount() = posterList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var isClicked = false
        holder.addButton.setOnClickListener(){

            if(isClicked){
                isClicked = false
                val movie = Movie("${movieNameList[position]}","${posterList[position]}","N/A",0,"N/A", false)
                holder.addButton.setImageResource(R.drawable.ic_add_item)
                Toast.makeText(holder.itemView.context,"${movieNameList[position]} unnaded from watchlist", Toast.LENGTH_SHORT)

            }
            else{
                isClicked = true
                val movie = Movie("${movieNameList[position]}","${posterList[position]}","N/A",0,"N/A", true)
                //val list = ArrayList<Movie>()
                // val adapter = MovieAdapter(list)
                //adapter.setMovieWatchlist(movie)
                val watchlist = WatchList()
                holder.addButton.setImageResource(R.drawable.ic_item_added)
                Toast.makeText(holder.itemView.context,"${movieNameList[position]} added to watchlist", Toast.LENGTH_SHORT)
            }

        }


        val entry = posterList[position]
        val name = movieNameList[position]
        Glide.with(holder.itemView)
            .load(entry)
            .into(holder.moviePoster)
        holder.nameTextView.text=name
    }
}