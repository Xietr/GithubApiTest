package com.example.githubapitest.presentation.di

import com.example.githubapitest.presentation.di.modules.InteractorsModule
import com.example.githubapitest.presentation.ui.scenes.detailed_user.DetailedUserFragment
import com.example.githubapitest.presentation.ui.scenes.users_list.UsersListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [InteractorsModule::class])
interface AppComponent {

    fun inject(usersListFragment: UsersListFragment)
    fun inject(usersListFragment: DetailedUserFragment)
}