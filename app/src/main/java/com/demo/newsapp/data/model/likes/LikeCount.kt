package com.demo.newsapp.data.model.likes


import com.google.gson.annotations.SerializedName

data class LikeCount(
    @SerializedName("likes")
    val likes: Int
)