package com.demo.newsapp.data.repository.likes.datasource

import com.demo.newsapp.data.model.likes.LikeCount
import retrofit2.Response

interface LikesRemoteDataSource {
    suspend fun getLikesCount(url: String): Response<LikeCount>
}