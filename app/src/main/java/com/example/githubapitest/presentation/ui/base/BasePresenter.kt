package com.example.githubapitest.presentation.ui.base

import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

abstract class BasePresenter<View : BaseView> : MvpPresenter<View>() {

    protected val compositeDisposable = CompositeDisposable()


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}