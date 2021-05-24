package com.example.demomvvm.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.demomvvm.data.model.MovieResponse
import com.example.demomvvm.databinding.ItemMovieBinding

class MovieViewHolder(
    private val movieBinding: ItemMovieBinding
) : RecyclerView.ViewHolder(movieBinding.root) {

    fun bind(movieResponse: MovieResponse) {
        movieBinding.movie = movieResponse
    }
}
