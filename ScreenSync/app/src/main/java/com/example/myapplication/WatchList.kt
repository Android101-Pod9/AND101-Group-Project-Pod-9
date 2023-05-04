package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class WatchList : AppCompatActivity() {
    // An array to store the list of movies in the watchlist
    private val movieList = mutableListOf<Movie>()
    private lateinit var homeButton : ImageButton
    // Get a reference to the recycler view
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var movie1 = Movie("Titanic", "www.com", "909090", 2023, "x")
        setContentView(R.layout.activity_watch_list)

        // Initialize the recycler view
        homeButton = findViewById(R.id.home_icon)
        recyclerView = findViewById(R.id.watchlist_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MovieAdapter(movieList)
        addMovie(movie1)

        homeButton.setOnClickListener(){}
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    // Add a movie to the watchlist
    fun addMovie(movie: Movie) {
        movieList.add(movie)

        // Notify the adapter that a new movie has been added

        recyclerView.adapter?.notifyItemInserted(movieList.size - 1)
    }
}