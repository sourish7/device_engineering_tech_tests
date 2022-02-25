package com.demo.newsapp.data.repository.news

import com.demo.newsapp.domain.repository.LikesRepository

class FakeLikesRepository : LikesRepository {

    override suspend fun getLikesCount(url: String): Int {
        return 1
    }
}