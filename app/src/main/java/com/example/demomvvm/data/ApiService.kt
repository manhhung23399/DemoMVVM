package com.example.demomvvm.data

import com.example.demomvvm.data.model.Movie
import retrofit2.http.GET

interface ApiService {
    @GET(ApiConfig.BASE_ENDPOINT)
    suspend fun getMovies(): Movie
}
