package com.ismailhakkiaydin.rickandmorty.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadFromUrl(
    url: String,
    placeholder: Int
) {
    Glide.with(this.context)
        .setDefaultRequestOptions(RequestOptions().placeholder(placeholder).error(placeholder))
        .load(url)
        .circleCrop()
        .into(this@loadFromUrl)
}