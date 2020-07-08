package com.example.githubapitest.domain.repositories

import com.example.githubapitest.domain.entities.UserEntity
import io.reactivex.rxjava3.core.Single

interface UserRepository {

    fun getUsers(fromUserId: Int): Single<List<UserEntity>>
}