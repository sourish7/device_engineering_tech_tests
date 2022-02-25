package com.demo.newsapp.presentation.di.core

import com.demo.newsapp.presentation.di.news.NewsSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {
    fun newsSubComponent():NewsSubComponent.Factory
}