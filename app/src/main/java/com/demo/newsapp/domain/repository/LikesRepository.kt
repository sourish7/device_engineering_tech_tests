package com.demo.newsapp.domain.repository

interface LikesRepository {
    suspend fun getLikesCount(url: String):Int?
}