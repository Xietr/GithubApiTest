package com.example.githubapitest.presentation.ui.scenes.detailed_user

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.githubapitest.R
import com.example.githubapitest.domain.entities.DetailedUserEntity
import com.example.githubapitest.presentation.App
import com.example.githubapitest.presentation.ui.base.BaseFragment
import com.example.githubapitest.presentation.ui.extensions.setIsVisible
import com.example.githubapitest.presentation.ui.extensions.setTextOrMakeGone
import kotlinx.android.synthetic.main.detailed_user_fragment.*
import moxy.ktx.moxyPresenter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Provider


class DetailedUserFragment : BaseFragment<DetailedUserPresenter>(R.layout.detailed_user_fragment),
    DetailedUserView {

    @Inject
    override lateinit var presenterProvider: Provider<DetailedUserPresenter>

    override val presenter: DetailedUserPresenter by moxyPresenter { presenterProvider.get() }

    private val args: DetailedUserFragmentArgs by navArgs()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter.login = args.login
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getDetailedUser()
    }

    override fun showData(detailedUserEntity: DetailedUserEntity) {
        detailedUserConstraintLayout.setIsVisible(true)

        Glide.with(this)
            .load(detailedUserEntity.avatarUrl)
            .centerInside()
            .into(detailedUserImageView)

        with(detailedUserEntity) {
            detailedUserName.setTextOrMakeGone(name)
            detailedUserLogin.setTextOrMakeGone(login)
            detailedUserBio.setTextOrMakeGone(bio)
            detailedUserCompany.setTextOrMakeGone(company)
            detailedUserBlog.setTextOrMakeGone(blog)
            detailedUserLocation.setTextOrMakeGone(location)
            detailedUserCreatedAndUpdated.setTextOrMakeGone(
                "Created: ${createdDate.formatToPresent()}\nUpdated: ${updateDate.formatToPresent()}"
            )
            detailedUserFollowersAndFollowing.setTextOrMakeGone(
                "$followersCount followers · $followingCount following"
            )
            detailedUserEmail.setTextOrMakeGone(email)
            detailedUserTwitter.setTextOrMakeGone(twitterUserName)
        }
    }

    private fun Date.formatToPresent(): String {
        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return format.format(this)
    }
}