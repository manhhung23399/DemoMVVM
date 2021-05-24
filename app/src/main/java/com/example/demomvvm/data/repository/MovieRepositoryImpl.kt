package com.example.demomvvm.data.repository

import com.example.demomvvm.data.MovieDataSource

class MovieRepositoryImpl(
    private val remote: MovieDataSource
) : MovieRepository {
    override suspend fun getMovies() = remote.getMovies()
}
