package com.example.githubapitest.domain.interactors

import com.example.githubapitest.domain.entities.UserEntity
import com.example.githubapitest.domain.repositories.UserRepository
import io.reactivex.rxjava3.core.Single

class GetUsersUseCaseImp(private val userRepository: UserRepository): GetUsersUseCase {

    override fun invoke(fromUserId: Int): Single<List<UserEntity>> =
        userRepository.getUsers(fromUserId)
}