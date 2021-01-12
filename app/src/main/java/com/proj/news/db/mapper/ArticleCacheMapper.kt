package com.proj.news.db.mapper

import com.proj.news.db.model.ArticleCache
import com.proj.news.domain.mapper.DomainMapper
import com.proj.news.domain.model.Article

class ArticleCacheMapper : DomainMapper<ArticleCache?, Article?> {

    override fun mapToDomainModel(model: ArticleCache?): Article {
        return Article(
            author = model?.author,
            content = model?.content,
            description = model?.description,
            publishedAt = model?.publishedAt,
            title = model?.title,
            url = model?.url,
            urlToImage = model?.urlToImage,
            sourceId = model?.sourceId,
            sourceName = model?.sourceName
        )
    }

    override fun mapFromDomainModel(domainModel: Article?): ArticleCache {
        return ArticleCache(
            author = domainModel?.author,
            content = domainModel?.content,
            description = domainModel?.description,
            publishedAt = domainModel?.publishedAt,
            title = domainModel?.title,
            url = domainModel?.url,
            urlToImage = domainModel?.urlToImage,
            sourceId = domainModel?.sourceId,
            sourceName = domainModel?.sourceName
        )
    }


    fun toDomainList(initial: List<ArticleCache>?): List<Article> {
        initial?.let {
            return it.map { mapToDomainModel(it) }
        }
        return listOf<Article>()
    }

    fun fromDomainList(initial: List<Article>?): List<ArticleCache> {
        initial?.let {
            return it.map { mapFromDomainModel(it) }
        }
        return listOf<ArticleCache>()
    }
}