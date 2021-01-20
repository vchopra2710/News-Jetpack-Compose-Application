package com.proj.news.repository

import com.proj.news.db.NewsDao
import com.proj.news.db.mapper.article.ArticleCacheMapper
import com.proj.news.db.model.ArticleCache
import com.proj.news.domain.model.Article
import com.proj.news.network.INewsClient
import com.proj.news.network.mapper.article.ArticleDtoMapper
import com.proj.news.network.model.articles.ArticleDto
import java.lang.Exception

class NewsRepositoryImpl
constructor(
    private val apiClient: INewsClient,
    private val articleDtoMapper: ArticleDtoMapper,
    private val articleCacheMapper: ArticleCacheMapper,
    private val newsDao: NewsDao
) : INewsRepository {

    override suspend fun fetchTopHeadLines(query: String?, country: String?): List<Article> {
        try {
            // dto model from rest api
            val networkBlog: List<ArticleDto>? = apiClient.fetchTopHeadLines(
                query = query, country = country
            ).articles

            // cache model
            val cacheDomain: List<ArticleCache> = articleDtoMapper.toCacheList(networkBlog)

            // insert list to database
            newsDao.insertArticles(cacheDomain)

            // domain blog
            val domainBlog: List<Article> = articleCacheMapper.toDomainList(cacheDomain)

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