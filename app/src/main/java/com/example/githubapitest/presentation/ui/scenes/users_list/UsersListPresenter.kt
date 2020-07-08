package com.example.githubapitest.presentation.ui.scenes.users_list

import com.example.githubapitest.domain.interactors.GetUsersUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import javax.inject.Inject


class UsersListPresenter @Inject constructor(private val getUsersUseCase: GetUsersUseCase) :
    MvpPresenter<UsersListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getUsersUseCase(0)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.updateAdapter(it)
            },{
                it.printStackTrace()
            })
    }
}