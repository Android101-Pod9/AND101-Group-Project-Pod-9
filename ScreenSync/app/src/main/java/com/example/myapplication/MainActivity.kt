package com.example.myapplication

import android.app.Fragment
import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.Group
import androidx.core.view.isInvisible
//import android.widget.SearchView
//import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    private lateinit var watchlistButton : Button
    private lateinit var movieNameList: MutableList<String>
    private lateinit var posterList: MutableList<String>
    private lateinit var comingSoonMovieNameList: MutableList<String>
    private lateinit var comingSoonPosterList: MutableList<String>
    private lateinit var comingSoonGenreList: MutableList<String>
    private lateinit var rvMovie: RecyclerView
    private lateinit var rvMovie2: RecyclerView
    private lateinit var searchView : SearchView
    private lateinit var rvSearchResults : RecyclerView
    private lateinit var movieDisplayGroup : Group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        watchlistButton = findViewById(R.id.watchlist_icon)
        movieNameList = mutableListOf()
        posterList = mutableListOf()
        comingSoonPosterList = mutableListOf()
        comingSoonMovieNameList = mutableListOf()
        comingSoonGenreList = mutableListOf()
        rvMovie = findViewById(R.id.Popular_list)
        rvMovie2 = findViewById(R.id.NewlyAdded_list)
        movieDisplayGroup = findViewById(R.id.display_movie_group)

        searchView = findViewById(R.id.search_bar)
        searchView.clearFocus()
        rvSearchResults = findViewById(R.id.search_results)

        getMovieURL()
        Log.d("getMovieURL", "movie poster URL set")

        displaySearchScreen(searchView, rvSearchResults, comingSoonMovieNameList)

        watchlistButton.setOnClickListener(){
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
                    comingSoonGenreList.add(comingSoonItems.getString("genres"))
                }
                val adapter = ComingSoonMoviesAdapter(comingSoonPosterList, comingSoonMovieNameList)
                rvMovie2.adapter = adapter
                rvMovie2.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
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

    private fun displaySearchScreen(searchView : SearchView, searchResults : RecyclerView, filteredList: List<String>){
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?) : Boolean {
                searchResults.visibility = View.VISIBLE
                movieDisplayGroup.visibility = View.GONE
                return false
            }
            override fun onQueryTextChange(newText: String?) : Boolean{
                if(newText.isNullOrBlank()){
                    searchResults.visibility = View.GONE
                    movieDisplayGroup.visibility = View.VISIBLE
                }
                else{
                    searchResults.visibility = View.VISIBLE
                    FilterList(newText, filteredList)
                    movieDisplayGroup.visibility = View.GONE
                }

                return true
            }

        })


    }

    private fun FilterList(newText: String, titleList : List<String>) {
        var filteredList = arrayListOf<String>()
        var filteredList2 = arrayListOf<String>()
        for(i in 0 until titleList.size){
            //TODO: what you need is the text and from that text check if
            if(titleList[i].toLowerCase().contains(newText.toLowerCase())){
                    filteredList.add(titleList[i])
                    filteredList2.add(comingSoonPosterList[i])
            }
           // var genreList = filteredList[i].split(",")
           // Log.d("Genres", "$genreList")
        }
        if(filteredList.isEmpty()){
            Toast.makeText(this, "No movies meet the criteria", Toast.LENGTH_SHORT).show()
        }
        else{
           val adapter = MovieSearchAdapter(comingSoonPosterList, comingSoonMovieNameList)
            rvSearchResults.adapter = adapter
            rvSearchResults.layoutManager = LinearLayoutManager(this@MainActivity)

            adapter.setFilteredList(filteredList,filteredList2)

        }

    }

}