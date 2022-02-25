package com.demo.newsapp.data.repository.news.datasource

import com.demo.newsapp.data.model.news.NewsList
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopNews():Response<NewsList>
}