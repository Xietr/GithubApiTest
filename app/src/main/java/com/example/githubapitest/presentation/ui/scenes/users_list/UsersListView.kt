package com.example.githubapitest.presentation.ui.scenes.users_list

import com.example.githubapitest.domain.entities.UserEntity
import com.example.githubapitest.presentation.ui.base.BaseView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.Skip

interface UsersListView : BaseView {
    @AddToEndSingle
    fun updateAdapter(users: List<UserEntity>)

    @Skip
    fun setIsProgressBarVisible(isVisible: Boolean)

    @OneExecution
    fun navigateToDetailedUserFragment(login: String)
}