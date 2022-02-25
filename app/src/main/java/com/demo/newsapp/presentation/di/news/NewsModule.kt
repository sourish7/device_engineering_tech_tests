package com.demo.newsapp.presentation.di.news

import com.demo.newsapp.domain.usecase.GetCommentsUseCase
import com.demo.newsapp.domain.usecase.GetLikesUseCase
import com.demo.newsapp.domain.usecase.GetNewsUseCase
import com.demo.newsapp.presentation.news.NewsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class NewsModule {

    @NewsScope
    @Provides
    fun providesNewsViewModelFactory(
        getNewsUseCase: GetNewsUseCase,
        getLikesUseCase: GetLikesUseCase,
        getCommentsUseCase: GetCommentsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            getNewsUseCase,
            getLikesUseCase,
            getCommentsUseCase
        )
    }
}