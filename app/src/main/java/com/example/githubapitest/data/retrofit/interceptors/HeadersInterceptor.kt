package com.example.githubapitest.data.retrofit.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Accept", "application/vnd.github.v3+json")
            .build()

        return chain.proceed(request)
    }
}