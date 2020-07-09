package com.example.githubapitest.presentation

import android.app.Application
import com.example.githubapitest.presentation.di.AppComponent
import com.example.githubapitest.presentation.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): AppComponent {
        return DaggerAppComponent.create()
    }
}