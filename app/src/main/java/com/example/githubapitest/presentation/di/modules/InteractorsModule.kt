package com.example.githubapitest.presentation.di.modules

import com.example.githubapitest.domain.interactors.GetUsersUseCase
import com.example.githubapitest.domain.interactors.GetUsersUseCaseImp
import com.example.githubapitest.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides

@Module(includes = [RepositoryModule::class])
class InteractorsModule {

    @Provides
    fun provideGetUsersUseCase(userRepository: UserRepository): GetUsersUseCase =
        GetUsersUseCaseImp(userRepository)
}