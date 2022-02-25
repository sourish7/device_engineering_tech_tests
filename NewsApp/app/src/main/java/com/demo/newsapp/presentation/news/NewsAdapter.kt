package com.demo.newsapp.presentation.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.newsapp.R
import com.demo.newsapp.data.model.news.Article
import com.demo.newsapp.databinding.ListItemBinding

class NewsAdapter(private val clickListener: (Article) -> Unit) :
    RecyclerView.Adapter<MyNewsViewHolder>() {
    private val newsList = ArrayList<Article?>()

    fun setList(news: List<Article?>) {
        newsList.clear()
        newsList.addAll(news)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyNewsViewHolder, position: Int) {
        val listItem = newsList[position]
        holder.bind(listItem, clickListener)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}

class MyNewsViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(news: Article?, clickListener: (Article) -> Unit) {
        binding.titleTextView.text = news?.description
        binding.authorTextView.text = news?.author
        val imagePosterUrl = news?.urlToImage

        Glide.with(binding.imageview.context)
            .load(imagePosterUrl)
            .into(binding.imageview)

        binding.listItemLayout.setOnClickListener {
            clickListener(news!!)
        }
    }
}