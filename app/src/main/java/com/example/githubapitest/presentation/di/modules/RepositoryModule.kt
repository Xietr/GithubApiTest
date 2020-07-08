package com.example.githubapitest.presentation.di.modules

import com.example.githubapitest.data.retrofit.GithubService
import com.example.githubapitest.data.retrofit.repositories.RetrofitUserRepository
import com.example.githubapitest.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(githubService: GithubService): UserRepository =
        RetrofitUserRepository(githubService)
}