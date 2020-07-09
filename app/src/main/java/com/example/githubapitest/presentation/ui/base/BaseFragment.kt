package com.example.githubapitest.presentation.ui.base

import android.widget.Toast
import moxy.MvpAppCompatFragment
import javax.inject.Provider

abstract class BaseFragment<P : BasePresenter<*>>(layoutId: Int) : MvpAppCompatFragment(layoutId),
    BaseView {

    abstract var presenterProvider: Provider<P>

    protected abstract val presenter: P

    override fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}