package com.demo.newsapp.data.repository.news

import com.demo.newsapp.data.model.news.Article
import com.demo.newsapp.domain.repository.NewsRepository

class FakeNewsRepository : NewsRepository {

    private val news = mutableListOf<Article>()

    init {
        news.add(
            Article(
                "author1",
                "content1",
                "descriptipn1",
                "12:00PM",
                "title1",
                "https:://abc.com",
                "https:://abc.com.html"
            )
        )
        news.add(
            Article(
                "author2",
                "content2",
                "descriptipn2",
                "12:01PM",
                "title2",
                "https:://abcd.com",
                "https:://abcd.com.html"
            )
        )
    }

    override suspend fun getTopNews(): List<Article> {
        return news
    }
}