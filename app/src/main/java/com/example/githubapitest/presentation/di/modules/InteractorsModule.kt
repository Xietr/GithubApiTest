package com.example.githubapitest.presentation.di.modules

import com.example.githubapitest.domain.interactors.GetDetailedUserUseCase
import com.example.githubapitest.domain.interactors.GetDetailedUserUseCaseImp
import com.example.githubapitest.domain.interactors.GetUsersUseCase
import com.example.githubapitest.domain.interactors.GetUsersUseCaseImp
import com.example.githubapitest.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(includes = [RepositoryModule::class])
class InteractorsModule {

    @Provides
    @Reusable
    fun provideGetUsersUseCase(userRepository: UserRepository): GetUsersUseCase =
        GetUsersUseCaseImp(userRepository)

    @Provides
    @Reusable
    fun provideGetDetailedUserUseCase(userRepository: UserRepository): GetDetailedUserUseCase =
        GetDetailedUserUseCaseImp(userRepository)
}