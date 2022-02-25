package com.demo.newsapp.data.repository.comments

import android.util.Log
import com.demo.newsapp.data.repository.comments.datasource.CommentsRemoteDataSource
import com.demo.newsapp.domain.repository.CommentsRepository
import java.lang.Exception

class CommentsRepositoryImpl(private val commentsRemoteDataSource: CommentsRemoteDataSource) :
    CommentsRepository {
    override suspend fun getCommentCount(url: String): Int {
        return getCommentsCountFromApi(url)
    }

    private suspend fun getCommentsCountFromApi(url: String): Int {
        var commentCount = 0
        try {
            val response = commentsRemoteDataSource.getCommentCount(url)
            val body = response.body()
            if (body != null) {
                commentCount = body.comments
            }
        } catch (exception: Exception) {
            Log.e("Exception", exception.message.toString())
        }
        return commentCount
    }
}