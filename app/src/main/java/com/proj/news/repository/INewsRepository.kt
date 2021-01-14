package com.proj.news.repository

import com.proj.news.domain.model.Article
import com.proj.news.events.DataStateEvent
import kotlinx.coroutines.flow.Flow

interface INewsRepository {

    // get top headlines from api
    suspend fun fetchTopHeadLines(query: String?, country: String?): List<Article>
}