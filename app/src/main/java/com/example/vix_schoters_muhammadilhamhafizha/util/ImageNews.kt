package com.example.vix_schoters_muhammadilhamhafizha.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.vix_schoters_muhammadilhamhafizha.R

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, urlString:String?){
    urlString?.let{
        Glide.with(imageView)
            .load(urlString)
            .placeholder(R.color.white)
            .error(R.color.white)
            .into(imageView)
    }
}