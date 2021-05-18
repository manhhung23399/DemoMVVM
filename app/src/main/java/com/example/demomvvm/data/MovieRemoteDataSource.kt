package com.example.demomvvm.data

class MovieRemoteDataSource(
    private val apiService: ApiService
) : MovieDataSource {
    override suspend fun getMovies() = apiService.getMovies()
}
