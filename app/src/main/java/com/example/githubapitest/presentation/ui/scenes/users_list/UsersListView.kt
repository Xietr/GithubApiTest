package com.example.githubapitest.presentation.ui.scenes.users_list

import com.example.githubapitest.domain.entities.UserEntity
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface UsersListView : MvpView {
    @AddToEndSingle
    fun updateAdapter(users: List<UserEntity>)

    @Skip
    fun setIsProgressBarVisible(isVisible: Boolean)

    @Skip
    fun showToast(message: String)
}