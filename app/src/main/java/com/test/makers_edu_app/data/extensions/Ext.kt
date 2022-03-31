package com.test.makers_edu_app.data.extensions

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String){
    Glide.with(context)
        .load(url)
        .into(this)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun showToast2(context: Context?, message: String) {
    context?.showToast(message)
}