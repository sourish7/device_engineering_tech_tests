package com.demo.newsapp.data.repository.news

import android.util.Log
import com.demo.newsapp.data.model.news.Article
import com.demo.newsapp.data.repository.news.datasource.NewsRemoteDataSource
import com.demo.newsapp.domain.repository.NewsRepository
import java.lang.Exception

class NewsRepositoryImpl(
private val newsRemoteDataSource: NewsRemoteDataSource
):NewsRepository {
    override suspend fun getTopNews(): List<Article> {
        return getNewsFromAPI()
    }

    private suspend fun getNewsFromAPI(): List<Article> {
        lateinit var newsList: List<Article>
        try {
            val response = newsRemoteDataSource.getTopNews()
            val body = response.body()
            if(body!=null){
                newsList = body.articles
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return newsList
    }
}