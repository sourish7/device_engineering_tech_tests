package com.demo.newsapp.domain.usecase

import com.demo.newsapp.domain.repository.CommentsRepository

class GetCommentsUseCase(private val commentsRepository: CommentsRepository) {
    suspend fun execute(url: String): Int? = commentsRepository.getCommentCount(url)
}