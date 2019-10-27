package com.example.project1.util

import android.view.View
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.example.project1.R
import kotlinx.android.synthetic.main.activity_main.*

fun View.toggleVisibility() {
    visibility = if (visibility == View.VISIBLE) { View.INVISIBLE} else {View.VISIBLE

    }
}

fun View.rotate90() {
    rotation = (rotation + 90) % 360
}


