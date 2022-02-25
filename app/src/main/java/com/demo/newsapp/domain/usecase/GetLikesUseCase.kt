package com.demo.newsapp.domain.usecase

import com.demo.newsapp.domain.repository.LikesRepository

class GetLikesUseCase(private val likesRepository: LikesRepository) {
    suspend fun execute(url: String): Int? = likesRepository.getLikesCount(url)
}