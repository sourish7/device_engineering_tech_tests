package com.demo.newsapp.data.repository.comments.datasourceimpl

import com.demo.newsapp.data.api.NewsService
import com.demo.newsapp.data.model.comments.CommentCount
import com.demo.newsapp.data.repository.comments.datasource.CommentsRemoteDataSource
import retrofit2.Response

class CommentsRemoteDataSourceImpl(private val newsService: NewsService):CommentsRemoteDataSource {
    override suspend fun getCommentCount(url: String): Response<CommentCount> {
        return newsService.getComments(url)
    }
}