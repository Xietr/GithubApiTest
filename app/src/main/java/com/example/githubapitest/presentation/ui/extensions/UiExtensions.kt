package com.example.githubapitest.presentation.ui.extensions

import android.view.View
import android.widget.TextView

fun View.setIsVisible(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun TextView.setTextOrMakeGone(text: String?) {
    if (text.isNullOrEmpty()) this.visibility = View.GONE
    else this.text = text
}