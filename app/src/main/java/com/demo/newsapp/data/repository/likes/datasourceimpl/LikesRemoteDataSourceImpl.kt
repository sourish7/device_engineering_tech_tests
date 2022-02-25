package com.demo.newsapp.data.repository.likes.datasourceimpl

import com.demo.newsapp.data.api.NewsService
import com.demo.newsapp.data.model.likes.LikeCount
import com.demo.newsapp.data.repository.likes.datasource.LikesRemoteDataSource
import retrofit2.Response

class LikesRemoteDataSourceImpl(private val newsService: NewsService) : LikesRemoteDataSource {
    override suspend fun getLikesCount(url: String): Response<LikeCount> {
        return newsService.getLikes(url)
    }
}