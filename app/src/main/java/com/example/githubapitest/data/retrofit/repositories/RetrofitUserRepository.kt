package com.example.githubapitest.data.retrofit.repositories

import com.example.githubapitest.data.retrofit.GithubService
import com.example.githubapitest.domain.entities.DetailedUserEntity
import com.example.githubapitest.domain.entities.UserEntity
import com.example.githubapitest.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single

class RetrofitUserRepository(private val service: GithubService) : UserRepository {

    override fun getUsers(fromUserId: Int): Single<List<UserEntity>> =
        service.getUsers(fromUserId)

    override fun getUser(login: String): Single<DetailedUserEntity> =
        service.getUser(login)
}