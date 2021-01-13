package com.proj.news.domain.model

data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?,
    val sourceId: String?,
    val sourceName: String?,
    val exception: Exception? = null
)