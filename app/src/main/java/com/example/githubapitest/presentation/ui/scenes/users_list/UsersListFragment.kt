package com.example.githubapitest.presentation.ui.scenes.users_list

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import com.example.githubapitest.R
import com.example.githubapitest.presentation.App
import com.example.githubapitest.presentation.ui.adapters.UsersListAdapter
import com.example.githubapitest.presentation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.users_list_fragment.*


class UsersListFragment : BaseFragment(R.layout.users_list_fragment) {

    override val viewModel: UsersListViewModel
        get() {
            TODO()
        }

    private val adapter: UsersListAdapter by lazy { UsersListAdapter(viewModel::onItemClicked) }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupRecyclerView()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            val savedRecyclerLayoutState =
                savedInstanceState.getParcelable<Parcelable>(LIST_STATE_KEY)
            recyclerView?.layoutManager?.onRestoreInstanceState(savedRecyclerLayoutState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(
            LIST_STATE_KEY,
            recyclerView?.layoutManager?.onSaveInstanceState()
        )
    }

    /*override fun updateAdapter(users: List<UserEntity>) {
        adapter.submitList(users.toList())//to pass the check of a new list
    }

    override fun setIsProgressBarVisible(isVisible: Boolean) =
        usersListProgressBar.setIsVisible(isVisible)

    override fun navigateToDetailedUserFragment(login: String) {
        val action = UsersListFragmentDirections.actionToDetailedUserFragment(login)
        findNavController().navigate(action)
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
*/

    companion object {
        const val LIST_STATE_KEY = "listStateKey"
    }
}
