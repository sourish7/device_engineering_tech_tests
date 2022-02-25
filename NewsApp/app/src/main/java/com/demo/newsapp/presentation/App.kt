package com.demo.newsapp.presentation

import android.app.Application
import com.demo.newsapp.BuildConfig
import com.demo.newsapp.presentation.di.Injector
import com.demo.newsapp.presentation.di.core.*
import com.demo.newsapp.presentation.di.news.NewsSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(
                RemoteDataModule(
                    BuildConfig.API_KEY,
                    BuildConfig.COUNTRY
                )
            )
            .build()
    }

    override fun createNewsSubComponent(): NewsSubComponent {
        return appComponent.newsSubComponent().create()
    }

}