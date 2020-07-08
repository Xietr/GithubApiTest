package com.example.githubapitest.presentation.ui.scenes.users_list

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapitest.R
import com.example.githubapitest.domain.entities.UserEntity
import com.example.githubapitest.presentation.App
import com.example.githubapitest.presentation.ui.adapters.UsersListAdapter
import com.example.githubapitest.presentation.ui.extensions.setVisibility
import com.example.githubapitest.presentation.ui.listeners.LinearPaginationScrollListener
import kotlinx.android.synthetic.main.users_list_fragment.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class UsersListFragment : MvpAppCompatFragment(R.layout.users_list_fragment), UsersListView {

    @Inject
    lateinit var presenterProvider: Provider<UsersListPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    private val adapter: UsersListAdapter by lazy { UsersListAdapter() }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this.context)
            adapter = this@UsersListFragment.adapter

            addOnScrollListener(
                LinearPaginationScrollListener(
                    this.layoutManager as LinearLayoutManager,
                    presenter::getUsers
                )
            )
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            val savedRecyclerLayoutState =
                savedInstanceState.getParcelable<Parcelable>(LIST_STATE_KEY)
            recyclerView.layoutManager!!.onRestoreInstanceState(savedRecyclerLayoutState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(
            LIST_STATE_KEY,
            recyclerView.layoutManager!!.onSaveInstanceState()
        )
    }

    override fun updateAdapter(users: List<UserEntity>) {
        adapter.submitList(users)
    }

    override fun setIsProgressBarVisible(isVisible: Boolean) =
        usersListProgressBar.setVisibility(isVisible)

    override fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


    companion object {
        const val LIST_STATE_KEY = "listStateKey"
    }
}
