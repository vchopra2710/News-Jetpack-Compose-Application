package com.proj.news.repository

import com.proj.news.db.NewsDao
import com.proj.news.db.mapper.ArticleCacheMapper
import com.proj.news.db.model.ArticleCache
import com.proj.news.domain.model.Article
import com.proj.news.events.DataStateEvent
import com.proj.news.events.DataStateEvent.Loading
import com.proj.news.events.DataStateEvent.Success
import com.proj.news.events.DataStateEvent.Error
import com.proj.news.network.IApiClient
import com.proj.news.network.mapper.ArticleDtoMapper
import com.proj.news.network.model.articles.ArticleDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class NewsRepositoryImpl
constructor(
    private val apiClient: IApiClient,
    private val articleDtoMapper: ArticleDtoMapper,
    private val articleCacheMapper: ArticleCacheMapper,
    private val newsDao: NewsDao
) : INewsRepository {

    override suspend fun fetchTopHeadLines(country: String?): Flow<DataStateEvent<Boolean>> =
        flow {
            emit(Loading)
            try {
                val networkBlog: List<ArticleDto>? = apiClient.fetchTopHeadLines(country).articles
                val domainBlog: List<Article> = articleDtoMapper.toDomainList(networkBlog)
                val cacheDomain: List<ArticleCache> = articleCacheMapper.fromDomainList(domainBlog)
                newsDao.insertArticles(cacheDomain)
                emit(Success(true))
            } catch (e: Exception) {
                emit(Error(e))
            }
        }

    override fun getTopHeadLinesFromDB(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}