package com.example.githubapitest.domain.interactors

import com.example.githubapitest.domain.entities.UserEntity
import io.reactivex.rxjava3.core.Single

interface GetUsersUseCase {

    operator fun invoke(fromUserId: Int): Single<List<UserEntity>>
}