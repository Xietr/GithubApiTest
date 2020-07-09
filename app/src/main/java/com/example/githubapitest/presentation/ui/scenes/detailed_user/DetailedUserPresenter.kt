package com.example.githubapitest.presentation.ui.scenes.detailed_user

import com.example.githubapitest.domain.interactors.GetDetailedUserUseCase
import com.example.githubapitest.presentation.ui.base.BasePresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

class DetailedUserPresenter @Inject constructor(private val getDetailedUserUseCase: GetDetailedUserUseCase) :
    BasePresenter<DetailedUserView>() {


    fun getDetailedUser(login: String) {
        getDetailedUserUseCase(login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showData(it)
            }, {
                it.printStackTrace()

                val message = if (it is HttpException) {
                    "error code: ${it.code()}" + it.message()
                } else {
                    it.localizedMessage
                } ?: "unexpected error"

                viewState.showToast("\uD83D\uDE28" + message)
            }).addTo(compositeDisposable)
    }
}