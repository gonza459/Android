package com.example.project1

import android.view.View

fun View.toggleVisibility() {
    visibility = if (visibility == View.VISIBLE) { View.INVISIBLE} else {View.VISIBLE

    }
}

fun View.dissapear() {
    visibility = if (visibility == View.VISIBLE) { View.GONE }
    else{ View.VISIBLE}
}