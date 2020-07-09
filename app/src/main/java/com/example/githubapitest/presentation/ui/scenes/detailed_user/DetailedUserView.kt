package com.example.githubapitest.presentation.ui.scenes.detailed_user

import com.example.githubapitest.domain.entities.DetailedUserEntity
import com.example.githubapitest.presentation.ui.base.BaseView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface DetailedUserView : BaseView {
    @AddToEndSingle
    fun showData(detailedUserEntity: DetailedUserEntity)
}


//  "url": "https://api.github.com/users/mojombo",
//  "html_url": "https://github.com/mojombo",

//  "type": "User",
//  "site_admin": false,
//  "hireable": null,

//  "repos_url": "https://api.github.com/users/mojombo/repos",
//  "public_repos": 61,

//  "followers_url": "https://api.github.com/users/mojombo/followers",
//  "following_url": "https://api.github.com/users/mojombo/following{/other_user}",
//  "followers": 22037,
//  "following": 11,
