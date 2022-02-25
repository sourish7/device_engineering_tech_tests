package com.demo.newsapp.data.repository.comments.datasource

import com.demo.newsapp.data.model.comments.CommentCount
import retrofit2.Response

interface CommentsRemoteDataSource {
    suspend fun getCommentCount(url: String): Response<CommentCount>
}