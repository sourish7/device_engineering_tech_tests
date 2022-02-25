package com.demo.newsapp.data.model.comments


import com.google.gson.annotations.SerializedName

data class CommentCount(
    @SerializedName("comments")
    val comments: Int
)