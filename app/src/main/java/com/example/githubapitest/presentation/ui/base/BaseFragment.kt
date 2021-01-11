package com.example.githubapitest.presentation.ui.base

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.annotation.IntRange
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.githubapitest.R
import com.google.android.material.snackbar.Snackbar
import javax.inject.Provider


abstract class BaseFragment(@LayoutRes layoutId: Int): Fragment(layoutId) {
    protected abstract val viewModel: BaseViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.
    }

/*    override fun showSnackbar(message: String) {
        getSnackBar(message, Snackbar.LENGTH_SHORT)?.show()
    }

    override fun showSnackbarWithAction(message: String, actionName: String, action: () -> Unit) {
        getSnackBar(message, Snackbar.LENGTH_INDEFINITE)?.setAction(actionName) { action.invoke() }
            ?.show()
    }*/


    private fun getSnackBar(
        message: String,
        @IntRange(from = -2, to = 0) length: Int
    ): Snackbar? {
        return view?.let {
            val snackbar = Snackbar.make(it, message, length)
            it.findViewById<TextView>(R.id.snackbar_action).setTextSize(
                TypedValue.COMPLEX_UNIT_SP,
                resources.getDimension(R.dimen.snackbar_size)
            )
            it.findViewById<TextView>(R.id.snackbar_text).setTextSize(
                TypedValue.COMPLEX_UNIT_SP,
                resources.getDimension(R.dimen.snackbar_size)
            )
            return snackbar
        }
    }
}