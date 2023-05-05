package com.example.myapplication

class Movie(
    val title: String,
    val posterUrl: String,
    val imdbId: String,
    val year: Int,
   // val plot: String
    val genres:String,
    val displayinWAtchlist :Boolean
) {
    override fun toString(): String {
        return "$title ($year)"
    }
}