package com.demo.newsapp.presentation.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.demo.newsapp.R
import com.demo.newsapp.databinding.ActivityDetailBinding
import com.demo.newsapp.presentation.di.Injector
import javax.inject.Inject

class NewsDetailFragment : Fragment() {

    @Inject
    lateinit var factory: NewsViewModelFactory
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding = ActivityDetailBinding.inflate(inflater, container, false)
        (requireActivity().application as Injector).createNewsSubComponent()
            .inject(this)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel = ViewModelProvider(requireActivity(), factory).get(NewsViewModel::class.java)
        showDetailInfo()
        showLikes()
        showComments()
    }

    private fun showDetailInfo() {
        newsViewModel.newsArticle.observe(viewLifecycleOwner) {
            detailBinding.textDetailTitle.text = it?.description
            detailBinding.textDetailContent.text = it?.content
            detailBinding.textDetailDetail.text = it?.title
            val imagePosterUrl = it?.urlToImage

            Glide.with(detailBinding.imageDetailNews.context)
                .load(imagePosterUrl)
                .into(detailBinding.imageDetailNews)
        }
    }

    private fun showLikes() {
        val likesLiveData = newsViewModel.getLikes()
        val likesText = getString(R.string.likes)
        likesLiveData.observe(viewLifecycleOwner) {
            "$likesText$it".also { detailBinding.likes.text = it }
        }
    }

    private fun showComments() {
        val commentsLiveData = newsViewModel.getComments()
        val commentsText = getString(R.string.comments)
        commentsLiveData.observe(viewLifecycleOwner) {
            "$commentsText$it".also { detailBinding.comments.text = it }
        }
    }
}