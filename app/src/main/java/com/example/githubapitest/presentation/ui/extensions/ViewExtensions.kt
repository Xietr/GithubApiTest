package com.example.githubapitest.presentation.ui.extensions

import android.view.View
import android.widget.TextView


fun TextView.setTextOrMakeGone(text: String?) {
    if (text.isNullOrEmpty()) this.visibility = View.GONE
    else this.text = text
}