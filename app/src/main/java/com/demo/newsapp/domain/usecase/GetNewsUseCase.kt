package com.demo.newsapp.domain.usecase

import com.demo.newsapp.data.model.news.Article
import com.demo.newsapp.domain.repository.NewsRepository

class GetNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): List<Article>? = newsRepository.getTopNews()
}