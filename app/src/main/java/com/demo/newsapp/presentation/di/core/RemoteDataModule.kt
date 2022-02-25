package com.demo.newsapp.presentation.di.core

import com.demo.newsapp.data.api.NewsService
import com.demo.newsapp.data.repository.comments.datasource.CommentsRemoteDataSource
import com.demo.newsapp.data.repository.comments.datasourceimpl.CommentsRemoteDataSourceImpl
import com.demo.newsapp.data.repository.likes.datasource.LikesRemoteDataSource
import com.demo.newsapp.data.repository.likes.datasourceimpl.LikesRemoteDataSourceImpl
import com.demo.newsapp.data.repository.news.datasource.NewsRemoteDataSource
import com.demo.newsapp.data.repository.news.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String, private val country: String) {

    @Singleton
    @Provides
    fun provideNewsDataSource(newsService: NewsService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsService, apiKey, country)
    }

    @Singleton
    @Provides
    fun provideLikesDataSource(newsService: NewsService): LikesRemoteDataSource {
        return LikesRemoteDataSourceImpl(newsService)
    }

    @Singleton
    @Provides
    fun provideCommentsDataSource(newsService: NewsService): CommentsRemoteDataSource {
        return CommentsRemoteDataSourceImpl(newsService)
    }
}