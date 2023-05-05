package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.util.ArrayList
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private var movieList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    // Inner class to hold the views for one item in the RecyclerView
      class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var movieList : List<Movie>
        val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        val posterImageView: ImageView = itemView.findViewById(R.id.poster_image_view)
        //val addButton: Button = itemView.findViewById(R.id.add_button)

        init{
            movieList = ArrayList<Movie>()
        }
    }
    fun setMovieWatchlist(movie : Movie){
        var newList = ArrayList<Movie>(movieList)
        newList.add(movie)
        movieList = newList
        notifyDataSetChanged()
    }

    fun removeMovie(name : String){
        for(i in 0 until movieList.size){

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]

        holder.titleTextView.text = movie.title
        Glide.with(holder.posterImageView)
            .load(movie.posterUrl)
            .into(holder.posterImageView)

        if(movie.displayinWAtchlist == true) {
//            // Add the movie to the watchlist
            (holder.itemView.context as WatchList).addMovie(movie)
        }

    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}