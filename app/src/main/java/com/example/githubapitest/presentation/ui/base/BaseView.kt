package com.example.githubapitest.presentation.ui.base

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface BaseView : MvpView {

    @Skip
    fun showSnackbar(message: String)

    @Skip
    fun showSnackbarWithAction(message: String, actionName: String, action: () -> Unit)
}