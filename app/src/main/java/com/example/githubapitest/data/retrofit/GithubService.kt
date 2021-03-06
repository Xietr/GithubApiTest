package com.example.githubapitest.data.retrofit

import com.example.githubapitest.domain.entities.DetailedUserEntity
import com.example.githubapitest.domain.entities.UserEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("users")
    fun getUsers(@Query("since") fromUserId: Int): Single<List<UserEntity>>

    @GET("users/{login}")
    fun getUser(@Path("login") login: String): Single<DetailedUserEntity>
}