package com.demo.newsapp.presentation.news

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.demo.newsapp.data.model.news.Article
import com.demo.newsapp.data.repository.news.FakeCommentsRepository
import com.demo.newsapp.data.repository.news.FakeLikesRepository
import com.demo.newsapp.data.repository.news.FakeNewsRepository
import com.demo.newsapp.domain.usecase.GetCommentsUseCase
import com.demo.newsapp.domain.usecase.GetLikesUseCase
import com.demo.newsapp.domain.usecase.GetNewsUseCase
import com.demo.newsapp.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var newsViewModel: NewsViewModel

    @Before
    fun setUp() {
        val fakeNewsRepository = FakeNewsRepository()
        val fakeLikesRepository = FakeLikesRepository()
        val fakeCommentsRepository = FakeCommentsRepository()
        val getNewsUseCase = GetNewsUseCase(fakeNewsRepository)
        val getLikesUseCase = GetLikesUseCase(fakeLikesRepository)
        val getCommentsUseCase = GetCommentsUseCase(fakeCommentsRepository)

        newsViewModel = NewsViewModel(getNewsUseCase, getLikesUseCase, getCommentsUseCase)
    }

    @Test
    fun getTopNews_returnsNewsList() {
        val news = mutableListOf<Article>()

        news.add(
            Article(
                "author1",
                "content1",
                "descriptipn1",
                "12:00PM",
                "title1",
                "https:://abc.com",
                "https:://abc.com.html"
            )
        )
        news.add(
            Article(
                "author2",
                "content2",
                "descriptipn2",
                "12:01PM",
                "title2",
                "https:://abcd.com",
                "https:://abcd.com.html"
            )
        )

        val newsList = newsViewModel.getNews().getOrAwaitValue()
        assertThat(newsList).isEqualTo(news)
    }

    @Test
    fun getLikes_returnsLikesCount() {
        val expectedLikeCount = 1

        val likes = newsViewModel.getLikes().getOrAwaitValue()
        assertThat(likes).isEqualTo(expectedLikeCount)
    }

    @Test
    fun getComments_returnsCommentCount() {
        val expectedCommentCount = 7

        val comment = newsViewModel.getComments().getOrAwaitValue()
        assertThat(comment).isEqualTo(expectedCommentCount)
    }
}