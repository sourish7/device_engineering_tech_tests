package com.demo.newsapp.presentation.di.core

import com.demo.newsapp.domain.repository.CommentsRepository
import com.demo.newsapp.domain.repository.LikesRepository
import com.demo.newsapp.domain.repository.NewsRepository
import com.demo.newsapp.domain.usecase.GetCommentsUseCase
import com.demo.newsapp.domain.usecase.GetLikesUseCase
import com.demo.newsapp.domain.usecase.GetNewsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository):GetNewsUseCase {
        return GetNewsUseCase(newsRepository)
    }

    @Provides
    fun provideGetLikesUseCase(likesRepository: LikesRepository):GetLikesUseCase {
        return GetLikesUseCase(likesRepository
        )
    }

    @Provides
    fun provideGetCommentsUseCase(commentsRepository: CommentsRepository):GetCommentsUseCase {
        return GetCommentsUseCase(commentsRepository)
    }
}