package com.latihan.cnn.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.latihan.cnn.R

class ViewBindingHelper {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["imageUrl"], requireAll = false)
        fun loadImage(view: ImageView, imageUrl: String?) {

            view.setImageDrawable(null)

            imageUrl?.let {

                Glide
                    .with(view.context)
                    .load(imageUrl)
                    .override(322, 322)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(view)

            }

        }
    }
}