package com.example.githubapitest.presentation.ui.glide

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.example.githubapitest.R

@GlideModule
class CustomGlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setDefaultRequestOptions(
            RequestOptions().apply {
                format(DecodeFormat.PREFER_ARGB_8888)//reduces size of loaded images
                placeholder(R.drawable.ic_github_logo)
            }
        )
    }
}