package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PopularMoviesAdapter (private val posterList: List<String>,private val movieNameList: List<String>): RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val moviePoster: ImageView
        val nameTextView: TextView
        init {
            // Find our RecyclerView item's ImageView for future use
            moviePoster = view.findViewById(R.id.imageView)
            nameTextView = view.findViewById(R.id.movieName)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular_movie_setup, parent, false)
        Log.d("create", "CharacterList ${posterList}")
        return ViewHolder(view)
    }
    override fun getItemCount() = posterList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = posterList[position]
        val name = movieNameList[position]
        Glide.with(holder.itemView)
            .load(entry)
            .into(holder.moviePoster)
        holder.nameTextView.text=name
    }
}