package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val movieList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    // Inner class to hold the views for one item in the RecyclerView
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        val posterImageView: ImageView = itemView.findViewById(R.id.poster_image_view)
        val addButton: Button = itemView.findViewById(R.id.add_button)
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

        holder.addButton.setOnClickListener {
            // Add the movie to the watchlist
            (holder.itemView.context as MainActivity).addMovie(movie)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}