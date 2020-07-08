package com.example.githubapitest.presentation.ui.scenes.users_list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapitest.R
import com.example.githubapitest.domain.entities.UserEntity
import com.example.githubapitest.presentation.App
import com.example.githubapitest.presentation.ui.adapters.UsersListAdapter
import kotlinx.android.synthetic.main.users_list_fragment.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class UsersListFragment : MvpAppCompatFragment(R.layout.users_list_fragment), UsersListView {

    @Inject
    lateinit var presenterProvider: Provider<UsersListPresenter>

    private val presenter by moxyPresenter { presenterProvider.get() }

    private lateinit var adapter: UsersListAdapter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = UsersListAdapter()
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this.context)
            adapter = this@UsersListFragment.adapter
        }
    }

    override fun updateAdapter(users: List<UserEntity>) {
        adapter.submitList(users)
    }
}