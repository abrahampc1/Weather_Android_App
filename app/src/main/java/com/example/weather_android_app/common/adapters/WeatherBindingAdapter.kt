package com.example.weather_android_app.common.adapters

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}

@BindingAdapter("isVisibleIfNotEmpty")
fun bindIsVisibleIfNotEmpty(view: View, text: CharSequence?) {
    view.visibility = if (!text.isNullOrEmpty()) View.VISIBLE else View.GONE
}



