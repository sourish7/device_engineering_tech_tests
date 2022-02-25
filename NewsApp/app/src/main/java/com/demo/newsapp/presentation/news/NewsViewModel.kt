package com.demo.newsapp.presentation.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.demo.newsapp.BuildConfig
import com.demo.newsapp.data.model.news.Article
import com.demo.newsapp.domain.usecase.GetCommentsUseCase
import com.demo.newsapp.domain.usecase.GetLikesUseCase
import com.demo.newsapp.domain.usecase.GetNewsUseCase

class NewsViewModel(
    private val newsUseCase: GetNewsUseCase,
    private val likesUseCase: GetLikesUseCase,
    private val commentsUseCase: GetCommentsUseCase
) : ViewModel() {

    private val _newsArticle = MutableLiveData<Article>()
    val newsArticle: LiveData<Article>
        get() = _newsArticle

    fun getNews(): LiveData<List<Article?>?> = liveData {
        val newsList = newsUseCase.execute()
        emit(newsList)
    }

    fun getLikes(): LiveData<Int?> = liveData {
        val likeUrl = getLikeUrl()
        val likeCount = likesUseCase.execute(likeUrl)
        emit(likeCount)
    }

    fun getComments(): LiveData<Int?> = liveData {
        val commentUrl = getCommentUrl()
        val commentCount = commentsUseCase.execute(commentUrl)
        emit(commentCount)
    }

    fun getNewsArticle(article: Article) {
        _newsArticle.value = article
    }

    private fun getLikeUrl(): String {
        val likeUrl = parseLikesUrl()
        return "${BuildConfig.COMMENT_URL}${BuildConfig.LIKE_PREFIX}$likeUrl"
    }

    private fun getCommentUrl(): String {
        val commentUrl = parseCommentUrl()
        return "${BuildConfig.COMMENT_URL}${BuildConfig.COMMENT_PREFIX}$commentUrl"
    }

    private fun parseCommentUrl() =
        newsArticle.value?.url?.replace("https://", "")?.
        replace("/", "-")

    private fun parseLikesUrl() = newsArticle.value?.url?.replace("https://", "")?.
    replace("/", "-")

}