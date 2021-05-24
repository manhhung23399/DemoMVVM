package com.example.demomvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.demomvvm.R
import com.example.demomvvm.data.model.MovieResponse

class MovieAdapter : ListAdapter<MovieResponse, MovieViewHolder>(MovieResponse.diffUtil),
    BindDataAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun setData(data: List<MovieResponse>?) {
        submitList(data)
    }
}
