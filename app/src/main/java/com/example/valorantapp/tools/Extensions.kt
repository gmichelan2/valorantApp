package com.example.valorantapp.tools

import android.widget.ImageView
import com.bumptech.glide.Glide

 inline fun ImageView.setHttpImage(url: String){
    Glide.with(this.context)
        .load(url)
        .into(this)
}
