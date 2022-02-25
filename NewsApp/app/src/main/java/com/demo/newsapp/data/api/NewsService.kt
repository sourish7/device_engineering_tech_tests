package com.demo.newsapp.data.api

import com.demo.newsapp.data.model.comments.CommentCount
import com.demo.newsapp.data.model.likes.LikeCount
import com.demo.newsapp.data.model.news.NewsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface NewsService {
    @GET("top-headlines")
    suspend fun getTopNewsHeadlines(
        @Query(
            "apiKey"
        ) apiKey: String,
        @Query(
            "country"
        ) country: String
    ): Response<NewsList>

    @GET
    suspend fun getLikes(
        @Url url: String
    ): Response<LikeCount>

    @GET
    suspend fun getComments(
        @Url url: String
    ): Response<CommentCount>
}