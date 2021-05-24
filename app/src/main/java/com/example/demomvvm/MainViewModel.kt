package com.example.demomvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demomvvm.data.model.MovieResponse
import com.example.demomvvm.data.repository.MovieRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: MovieRepository
) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieResponse>>()
    val movies: LiveData<List<MovieResponse>>
        get() = _movies
    private var _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _error.postValue(throwable.message)
    }

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val moviesFromApi = repo.getMovies()
            _movies.postValue(moviesFromApi.results)
        }
    }
}
