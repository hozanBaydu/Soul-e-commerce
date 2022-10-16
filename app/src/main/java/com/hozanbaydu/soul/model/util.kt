package com.hozanbaydu.soul.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("android:src")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}