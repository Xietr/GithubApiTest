package com.example.githubapitest.presentation.ui.scenes.users_list

import com.example.githubapitest.domain.entities.UserEntity
import com.example.githubapitest.domain.interactors.GetUsersUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import retrofit2.HttpException
import javax.inject.Inject


class UsersListPresenter @Inject constructor(private val getUsersUseCase: GetUsersUseCase) :
    MvpPresenter<UsersListView>() {

    private var lastId = 0
    private var allLoadedUsers = arrayListOf<UserEntity>()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getUsers()
    }

    fun getUsers() {
        getUsersUseCase(lastId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { viewState.setIsProgressBarVisible(true) }
            .doFinally { viewState.setIsProgressBarVisible(false) }
            .subscribe({
                allLoadedUsers.addAll(it)
                viewState.updateAdapter(allLoadedUsers)
                lastId = it.last().id
            }, {
                it.printStackTrace()

                val message = if (it is HttpException) {
                    "error code: ${it.code()}" + it.message()
                } else {
                    it.localizedMessage
                } ?: "unexpected error"

                viewState.showToast("\uD83D\uDE28" + message)
            })
    }
}