package com.example.githubapitest.domain.interactors

import com.example.githubapitest.domain.entities.DetailedUserEntity
import com.example.githubapitest.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single

class GetDetailedUserUseCaseImp(private val userRepository: UserRepository) :
    GetDetailedUserUseCase {

    override fun invoke(login: String): Single<DetailedUserEntity> =
        userRepository.getUser(login)
}