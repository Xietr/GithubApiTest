package com.example.githubapitest.presentation.ui.scenes.users_list

import com.example.githubapitest.domain.entities.UserEntity
import com.example.githubapitest.domain.interactors.GetUsersUseCase
import com.example.githubapitest.presentation.ui.base.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject


class UsersListPresenter @Inject constructor(private val getUsersUseCase: GetUsersUseCase) :
    BasePresenter<UsersListView>() {

    private var lastId = 0
    private var allLoadedUsers = arrayListOf<UserEntity>()
    private var isLoading = false


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getUsers()
    }

    fun getUsers() {
        if (isLoading) return

        getUsersUseCase(lastId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                isLoading = true
                viewState.setIsProgressBarVisible(true)
            }
            .doFinally {
                isLoading = false
                viewState.setIsProgressBarVisible(false)
            }
            .subscribe({
                allLoadedUsers.addAll(it)
                viewState.updateAdapter(allLoadedUsers)
                lastId = it.last().id
            }, {
                it.printStackTrace()

                val message = if (it is HttpException) {
                    "error code: ${it.code()} " + it.message()
                } else {
                    it.localizedMessage
                } ?: "unexpected error"

                viewState.showToast("\uD83D\uDE28" + message)
            }).addTo(compositeDisposable)
    }

    fun onItemClicked(login: String) = viewState.navigateToDetailedUserFragment(login)
}