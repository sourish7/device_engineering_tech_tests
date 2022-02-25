package com.demo.newsapp.data.repository.news

import com.demo.newsapp.domain.repository.CommentsRepository

class FakeCommentsRepository : CommentsRepository {

    override suspend fun getCommentCount(url: String): Int {
        return 7
    }
}