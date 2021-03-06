package com.example.demomvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.demomvvm.data.ApiConfig

@BindingAdapter("loadImage")
fun ImageView.loadImage(uri: String) {
    Glide.with(context)
        .load(ApiConfig.BASE_URL_IMAGE + uri)
        .into(this)
}
