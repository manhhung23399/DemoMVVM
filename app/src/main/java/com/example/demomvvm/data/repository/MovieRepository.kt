package com.example.demomvvm.data.repository

import com.example.demomvvm.data.model.Movie

interface MovieRepository {
    suspend fun getMovies(): Movie
}
