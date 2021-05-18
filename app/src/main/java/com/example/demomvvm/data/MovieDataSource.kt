package com.example.demomvvm.data

import com.example.demomvvm.data.model.Movie

interface MovieDataSource {
    suspend fun getMovies(): Movie
}
