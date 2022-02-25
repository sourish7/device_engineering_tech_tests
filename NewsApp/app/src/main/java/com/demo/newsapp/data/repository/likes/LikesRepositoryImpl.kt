package com.demo.newsapp.data.repository.likes

import android.util.Log
import com.demo.newsapp.data.repository.likes.datasource.LikesRemoteDataSource
import com.demo.newsapp.domain.repository.LikesRepository
import java.lang.Exception

class LikesRepositoryImpl(private val likesRemoteDataSource: LikesRemoteDataSource) :
    LikesRepository {
    override suspend fun getLikesCount(url: String): Int {
        return getLikesCountFromApi(url)
    }

    private suspend fun getLikesCountFromApi(url: String): Int {
        var likeCount = 0
        try {
            val response = likesRemoteDataSource.getLikesCount(url)
            val body = response.body()
            if (body != null) {
                likeCount = body.likes
            }
        } catch (exception: Exception) {
            Log.e("Exception", exception.message.toString())
        }
        return likeCount
    }
}