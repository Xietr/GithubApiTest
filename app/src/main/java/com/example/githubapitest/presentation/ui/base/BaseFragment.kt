package com.example.githubapitest.presentation.ui.base

import android.util.TypedValue
import android.widget.TextView
import androidx.annotation.IntRange
import com.example.githubapitest.R
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import javax.inject.Provider


abstract class BaseFragment<P : BasePresenter<*>>(layoutId: Int) :
    MvpAppCompatFragment(layoutId),
    BaseView {

    abstract var presenterProvider: Provider<P>

    protected abstract val presenter: P

    override fun showSnackbar(message: String) {
        getSnackBar(message, Snackbar.LENGTH_SHORT)?.show()
    }

    override fun showSnackbarWithAction(message: String, actionName: String, action: () -> Unit) {
        getSnackBar(message, Snackbar.LENGTH_INDEFINITE)?.setAction(actionName) { action.invoke() }
            ?.show()
    }


    private fun getSnackBar(
        message: String,
        @IntRange(from = -2, to = 0) length: Int
    ): Snackbar? {
        return view?.let {
            val snackbar = Snackbar.make(it, message, length)
            val view = snackbar.view
            view.findViewById<TextView>(R.id.snackbar_action).setTextSize(
                TypedValue.COMPLEX_UNIT_SP,
                resources.getDimension(R.dimen.snackbar_size)
            )
            view.findViewById<TextView>(R.id.snackbar_text).setTextSize(
                TypedValue.COMPLEX_UNIT_SP,
                resources.getDimension(R.dimen.snackbar_size)
            )
            return snackbar
        }
    }
}