package com.example.githubapitest.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubapitest.R
import com.example.githubapitest.domain.entities.UserEntity
import kotlinx.android.synthetic.main.list_item_user.view.*

class UsersListAdapter(private val onItemClicked: (String) -> Unit) :
    ListAdapter<UserEntity, UsersListAdapter.UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_user, parent, false)
        return UserViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class UserViewHolder(itemView: View, private val onItemCLicked: (String) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(userEntity: UserEntity) {
            with(itemView) {
                Glide.with(context)
                    .load(userEntity.avatarUrl)
                    .centerInside()
                    .into(listUserImageView)

                listUserLoginTextView.text = userEntity.login

                setOnClickListener {
                    onItemCLicked.invoke(userEntity.login)
                }
            }
        }
    }
}

private class UserDiffCallback : DiffUtil.ItemCallback<UserEntity>() {

    override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity) =
        oldItem.id == newItem.id

    override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
        return oldItem.avatarUrl == newItem.avatarUrl && oldItem.login == newItem.login
    }
}