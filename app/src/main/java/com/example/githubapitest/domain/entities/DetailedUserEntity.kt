package com.example.githubapitest.domain.entities

import com.google.gson.annotations.SerializedName
import java.util.*

data class DetailedUserEntity(
    val login: String, //
    val id: Int,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("avatar_url")
    val avatarUrl: String, //
    @SerializedName("gravatar_id")
    val gravatarId: String,
    val type: String,
    @SerializedName("site_admin")
    val isSiteAdmin: Boolean,
    val name: String, //
    val company: String?, //
    val blog: String?, //
    val location: String?, //
    val email: String?, //
    val hireable: Boolean?, //
    val bio: String?, //
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

//    "url": "https://api.github.com/users/mojombo",
//    "html_url": "https://github.com/mojombo",
//    "followers_url": "https://api.github.com/users/mojombo/followers",
//    "following_url": "https://api.github.com/users/mojombo/following{/other_user}",
//    "gists_url": "https://api.github.com/users/mojombo/gists{/gist_id}",
//    "starred_url": "https://api.github.com/users/mojombo/starred{/owner}{/repo}",
//    "subscriptions_url": "https://api.github.com/users/mojombo/subscriptions",
//    "organizations_url": "https://api.github.com/users/mojombo/orgs",
//    "repos_url": "https://api.github.com/users/mojombo/repos",
//    "events_url": "https://api.github.com/users/mojombo/events{/privacy}",
//    "received_events_url": "https://api.github.com/users/mojombo/received_events",