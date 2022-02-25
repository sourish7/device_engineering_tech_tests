package com.demo.newsapp.presentation.di.news

import com.demo.newsapp.MainActivity
import com.demo.newsapp.presentation.news.NewsDetailFragment
import com.demo.newsapp.presentation.news.NewsFragment
import dagger.Subcomponent

@NewsScope
@Subcomponent(modules = [NewsModule::class])
interface NewsSubComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(newsFragment: NewsFragment)
    fun inject(newsDetailFragment: NewsDetailFragment)
    @Subcomponent.Factory
    interface Factory {
        fun create():NewsSubComponent
    }
}