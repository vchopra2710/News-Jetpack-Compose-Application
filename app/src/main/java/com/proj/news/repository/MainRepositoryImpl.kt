package com.proj.news.repository

import com.proj.news.domain.model.Article
import com.proj.news.repository.news.INewsRepository

class MainRepositoryImpl
constructor(
    private val newsRepository: INewsRepository
) : IMainRepository {

    override suspend fun fetchTopHeadLines(query: String?, country: String?): List<Article> {
        return newsRepository.fetchTopHeadLines(query = query, country = country)
    }
}