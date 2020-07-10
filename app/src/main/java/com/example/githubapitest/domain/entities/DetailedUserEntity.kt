package com.example.githubapitest.domain.entities

import com.google.gson.annotations.SerializedName
import java.util.*

data class DetailedUserEntity(
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
    val isSiteAdmin: Boolean,
    val name: String,
    val company: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val hireable: Boolean?,
    val bio: String?,
    @SerializedName("twitter_username")
    val twitterUserName: String?,
    @SerializedName("public_repos")
    val publicReposCount: Int,
    @SerializedName("public_gists")
    val publicGistsCount: Int,
    @SerializedName("followers")
    val followersCount: Int,
    @SerializedName("following")
    val followingCount: Int,
    @SerializedName("created_at")
    val createdDate: Date,
    @SerializedName("updated_at")
    val updateDate: Date
)
