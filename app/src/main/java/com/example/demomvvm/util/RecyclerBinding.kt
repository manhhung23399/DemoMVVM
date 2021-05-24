package com.example.demomvvm.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvvm.adapter.BindDataAdapter
import com.example.demomvvm.data.model.MovieResponse

@BindingAdapter("data")
fun setDataRecycler(recyclerView: RecyclerView, data: List<MovieResponse>?) {
    (recyclerView.adapter as BindDataAdapter).setData(data)
}
