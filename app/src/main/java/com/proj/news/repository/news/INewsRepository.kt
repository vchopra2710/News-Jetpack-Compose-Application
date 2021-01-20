package com.proj.news.repository.news

import com.proj.news.domain.model.Article

interface INewsRepository {

    // get top headlines from api
    suspend fun fetchTopHeadLines(query: String?, country: String?): List<Article>
}