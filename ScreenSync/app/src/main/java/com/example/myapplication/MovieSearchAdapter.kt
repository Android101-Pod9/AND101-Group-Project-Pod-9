package com.example.myapplication

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieSearchAdapter(private var posterList : List<String>, private var movieNameList : List<String>) : RecyclerView.Adapter<MovieSearchAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val posterList : ImageView
        val movieNameList : TextView

        init{
            posterList = view.findViewById(R.id.search_poster)
            movieNameList = view.findViewById(R.id.movie_title)

        }
    }

     fun setFilteredList(filteredList : List<String>, filteredList2 : List<String>){
        this.movieNameList = filteredList
         this.posterList = filteredList2
        notifyDataSetChanged()
         Log.d("Change List", "${filteredList.toString()}")

    }


    override fun onCreateViewHolder(parent : ViewGroup, viewTipe: Int) : MovieSearchAdapter.ViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_movie_search, parent, false)

        return ViewHolder(view)

    }

    override fun getItemCount() = posterList.size

    override fun onBindViewHolder(holder: MovieSearchAdapter.ViewHolder, position: Int) {
        holder.movieNameList.setText(movieNameList[position])

        Glide.with(holder.itemView)
            .load(posterList[position])
            .centerCrop()
            .into(holder.posterList)

        val toast = "more info coming soon"
        holder.posterList.setOnClickListener(){
            Toast.makeText(holder.itemView.context,"$toast",Toast.LENGTH_SHORT).show()
        }

    }



}