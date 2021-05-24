package com.example.demomvvm.adapter

import com.example.demomvvm.data.model.MovieResponse

interface BindDataAdapter {
    fun setData(data: List<MovieResponse>?)
}
