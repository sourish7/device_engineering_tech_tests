package com.demo.newsapp.presentation.di

import com.demo.newsapp.presentation.di.news.NewsSubComponent

interface Injector {
    fun createNewsSubComponent():NewsSubComponent
}