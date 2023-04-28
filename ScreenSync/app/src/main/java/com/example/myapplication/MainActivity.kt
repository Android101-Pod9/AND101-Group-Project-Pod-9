package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Movie
import com.example.myapplication.MovieAdapter

class MainActivity : AppCompatActivity() {
    // An array to store the list of movies in the watchlist
    private val movieList = mutableListOf<Movie>()

    // Get a reference to the recycler view
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the recycler view
        recyclerView = findViewById(R.id.watchlist_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieAdapter(movieList)
    }

    // Add a movie to the watchlist
    fun addMovie(movie: Movie) {
        movieList.add(movie)

        // Notify the adapter that a new movie has been added
        recyclerView.adapter?.notifyItemInserted(movieList.size - 1)
    }
}