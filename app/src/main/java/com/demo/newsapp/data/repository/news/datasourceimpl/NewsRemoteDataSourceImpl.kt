package com.demo.newsapp.data.repository.news.datasourceimpl

import com.demo.newsapp.data.api.NewsService
import com.demo.newsapp.data.model.news.NewsList
import com.demo.newsapp.data.repository.news.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsService: NewsService,
    private val apiKey:String,
    private val country:String
): NewsRemoteDataSource {
    override suspend fun getTopNews(): Response<NewsList> {
        return newsService.getTopNewsHeadlines(apiKey, country)
    }
}