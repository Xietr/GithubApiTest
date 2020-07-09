package com.example.githubapitest.presentation.ui.base

import moxy.MvpView
import moxy.viewstate.strategy.alias.Skip

interface BaseView : MvpView {

    @Skip
    fun showToast(message: String)
}