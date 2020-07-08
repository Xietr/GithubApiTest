package com.example.githubapitest.presentation.ui.scenes.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubapitest.R
import com.example.githubapitest.presentation.ui.scenes.users_list.UsersListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, UsersListFragment())
                    .commitNow()
        }
    }
}