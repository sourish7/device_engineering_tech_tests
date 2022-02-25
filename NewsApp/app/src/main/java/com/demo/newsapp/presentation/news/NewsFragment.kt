package com.demo.newsapp.presentation.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.newsapp.R
import com.demo.newsapp.data.model.news.Article
import com.demo.newsapp.databinding.ActivityNewsBinding
import com.demo.newsapp.presentation.di.Injector
import javax.inject.Inject

class NewsFragment: Fragment() {

    @Inject
    lateinit var factory: NewsViewModelFactory
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: ActivityNewsBinding
    private lateinit var adapter: NewsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = ActivityNewsBinding.inflate(inflater, container, false)
        (requireActivity().application as Injector).createNewsSubComponent()
            .inject(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel = ViewModelProvider(requireActivity(), factory).get(NewsViewModel::class.java)
        initRecyclerview()
    }

    private fun initRecyclerview() {
        binding.newsRecyclerView.layoutManager =
            LinearLayoutManager(requireActivity())
        adapter = NewsAdapter { onClickItem:Article -> onClickItem(onClickItem)
        }
        binding.newsRecyclerView.adapter = adapter
        displayTopNews()
    }

    private fun displayTopNews() {
        binding.newsProgressBar.visibility = View.VISIBLE
        val responseLiveData = newsViewModel.getNews()
        responseLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.newsProgressBar.visibility = View.GONE
            } else {
                binding.newsProgressBar.visibility = View.GONE
                Toast.makeText(
                    requireActivity(), "No data available",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun onClickItem(article: Article) {
        newsViewModel.getNewsArticle(article)
        Navigation.findNavController(binding.root).navigate(R.id.action_newsFragment_to_newsDetailFragment)
    }
}