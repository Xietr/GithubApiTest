package com.example.githubapitest.domain.entities

import com.google.gson.annotations.SerializedName

data class UserEntity (
    val login: String,
    val id: Int,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("gravatar_id")
    val gravatarId: String,
    val type: String,
    @SerializedName("site_admin")
    val isSiteAdmin: Boolean
)

