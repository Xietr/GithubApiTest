package com.example.githubapitest.domain.interactors

import com.example.githubapitest.domain.entities.DetailedUserEntity
import io.reactivex.rxjava3.core.Single

interface GetDetailedUserUseCase {
    operator fun invoke(login: String): Single<DetailedUserEntity>
}