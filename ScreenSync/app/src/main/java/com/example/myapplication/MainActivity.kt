package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    private lateinit var movieNameList: MutableList<String>
    private lateinit var posterList: MutableList<String>
    private lateinit var comingSoonMovieNameList: MutableList<String>
    private lateinit var comingSoonPosterList: MutableList<String>
    private lateinit var rvMovie: RecyclerView
    private lateinit var rvMovie2: RecyclerView
    private lateinit var toWatchList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieNameList = mutableListOf()
        posterList = mutableListOf()
        comingSoonPosterList = mutableListOf()
        comingSoonMovieNameList = mutableListOf()
        rvMovie = findViewById(R.id.Popular_list)
        rvMovie2 = findViewById(R.id.NewlyAdded_list)
       toWatchList = findViewById(R.id.toWatchlist)
        getMovieURL()
        Log.d("getMovieURL", "movie poster URL set")


        toWatchList.setOnClickListener() {
            val intent = Intent(this, WatchList::class.java)
            startActivity(intent)

        }



    }

    private fun getMovieURL() {
        val client = AsyncHttpClient()
        val iMDBkey = "k_uv3vgmx4"
        val url = "https://imdb-api.com/en/API/MostPopularMovies/" + iMDBkey
        client[url, object : JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {
                val movieArray = json.jsonObject.getJSONArray("items")
                for (i in 0 until movieArray.length()) {
                    val rankOfMovie = movieArray.getJSONObject(i)
                    posterList.add(rankOfMovie.getString("image"))
                    movieNameList.add(rankOfMovie.getString("title"))
                }
                val adapter = PopularMoviesAdapter(posterList, movieNameList)
                rvMovie.adapter = adapter
                rvMovie.layoutManager =
                    LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
                rvMovie.addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.HORIZONTAL))
            }
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Character Error", errorResponse)
            }
        }]
         //Coming Soon Part
        val ComingSoonURL = "https://imdb-api.com/en/API/ComingSoon/" + iMDBkey
        client[ComingSoonURL, object : JsonHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {
                val comingSoonMovieArray = json.jsonObject.getJSONArray("items")
                for (i in 0 until comingSoonMovieArray.length()) {
                    val comingSoonItems = comingSoonMovieArray.getJSONObject(i)
                    comingSoonPosterList.add(comingSoonItems.getString("image"))
                    comingSoonMovieNameList.add(comingSoonItems.getString("title"))
                }
                val adapter = ComingSoonMoviesAdapter(comingSoonPosterList, comingSoonMovieNameList)
                rvMovie2.adapter = adapter
                rvMovie2.layoutManager =
                    LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Character Error", errorResponse)
            }
        }]
    }
}