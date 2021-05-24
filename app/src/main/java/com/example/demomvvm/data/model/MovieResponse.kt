package com.example.demomvvm.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MovieResponse>() {
            override fun areItemsTheSame(oldItem: MovieResponse, newItem: MovieResponse) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MovieResponse, newItem: MovieResponse) =
                oldItem == newItem
        }
    }
}
