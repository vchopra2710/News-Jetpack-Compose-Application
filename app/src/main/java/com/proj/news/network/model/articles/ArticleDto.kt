package com.proj.news.network.model.articles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArticleDto(
    @SerializedName("author") @Expose val author: String?,
    @SerializedName("content") @Expose val content: String?,
    @SerializedName("description") @Expose val description: String?,
    @SerializedName("publishedAt") @Expose val publishedAt: String?,
    @SerializedName("source") @Expose val source: Source?,
    @SerializedName("title") @Expose val title: String?,
    @SerializedName("url") @Expose val url: String?,
    @SerializedName("urlToImage") @Expose val urlToImage: String?
)