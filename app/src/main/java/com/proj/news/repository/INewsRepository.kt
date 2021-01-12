package com.proj.news.repository

import com.proj.news.domain.model.Article
import com.proj.news.events.DataStateEvent
import kotlinx.coroutines.flow.Flow

interface INewsRepository {

    // get top headlines from api
    suspend fun fetchTopHeadLines(country: String?): Flow<DataStateEvent<Boolean>>

    // get top head lines from db
    fun getTopHeadLinesFromDB(): Flow<List<Article>>
}