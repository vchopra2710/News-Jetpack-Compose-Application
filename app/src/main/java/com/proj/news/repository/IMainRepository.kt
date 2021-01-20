package com.proj.news.repository

import com.proj.news.domain.model.Article

interface IMainRepository {

    // get top headlines from api
    suspend fun fetchTopHeadLines(query: String?, country: String?): List<Article>
}