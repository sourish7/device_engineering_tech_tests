package com.demo.newsapp.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.newsapp.domain.usecase.GetCommentsUseCase
import com.demo.newsapp.domain.usecase.GetLikesUseCase
import com.demo.newsapp.domain.usecase.GetNewsUseCase
import javax.inject.Singleton

@Singleton
class NewsViewModelFactory(
private val getNewsUseCase: GetNewsUseCase,
private val getLikesUseCase: GetLikesUseCase,
private val getCommentsUseCase: GetCommentsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(getNewsUseCase,getLikesUseCase,getCommentsUseCase) as T
    }
}