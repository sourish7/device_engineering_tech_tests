package com.demo.newsapp.domain.repository

interface CommentsRepository {
    suspend fun getCommentCount(url: String):Int?
}