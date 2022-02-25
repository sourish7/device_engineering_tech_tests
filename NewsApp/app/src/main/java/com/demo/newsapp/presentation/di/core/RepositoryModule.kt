package com.demo.newsapp.presentation.di.core

import com.demo.newsapp.data.repository.comments.CommentsRepositoryImpl
import com.demo.newsapp.data.repository.comments.datasource.CommentsRemoteDataSource
import com.demo.newsapp.data.repository.likes.LikesRepositoryImpl
import com.demo.newsapp.data.repository.likes.datasource.LikesRemoteDataSource
import com.demo.newsapp.data.repository.news.NewsRepositoryImpl
import com.demo.newsapp.data.repository.news.datasource.NewsRemoteDataSource
import com.demo.newsapp.domain.repository.CommentsRepository
import com.demo.newsapp.domain.repository.LikesRepository
import com.demo.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDatasource: NewsRemoteDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDatasource)
    }

    @Singleton
    @Provides
    fun provideLikesRepository(
        likesRemoteDataSource: LikesRemoteDataSource
    ): LikesRepository {
        return LikesRepositoryImpl(likesRemoteDataSource)
    }

    @Singleton
    @Provides
    fun provideCommentsRepository(
        commentsRemoteDataSource: CommentsRemoteDataSource
    ): CommentsRepository {
        return CommentsRepositoryImpl(commentsRemoteDataSource)
    }
}