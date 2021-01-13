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

    override suspend fun fetchTopHeadLines(country: String?): List<Article> {
        try {
            val networkBlog: List<ArticleDto>? = apiClient.fetchTopHeadLines(country).articles
            val domainBlog: List<Article> = articleDtoMapper.toDomainList(networkBlog)
            val cacheDomain: List<ArticleCache> = articleCacheMapper.fromDomainList(domainBlog)
            newsDao.insertArticles(cacheDomain)
            return domainBlog
        } catch (e: Exception) {
            val exArticleDomainBlog = Article(
                author = null, content = null, description = null, publishedAt = null, title = null,
                url = null, urlToImage = null, sourceId = null, sourceName = null, exception = e
            )
            return mutableListOf<Article>(exArticleDomainBlog)
        }
    }
}