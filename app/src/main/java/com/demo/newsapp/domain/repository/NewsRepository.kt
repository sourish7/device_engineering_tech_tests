package com.demo.newsapp.domain.repository

import com.demo.newsapp.data.model.news.Article

interface NewsRepository {
    suspend fun getTopNews():List<Article>?
}