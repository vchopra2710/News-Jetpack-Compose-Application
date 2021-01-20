package com.proj.news.network.mapper

import com.proj.news.db.mapper.CacheMapper
import com.proj.news.db.model.ArticleCache
import com.proj.news.network.model.articles.ArticleDto
import com.proj.news.network.model.articles.Source

class ArticleDtoMapper : CacheMapper<ArticleDto?, ArticleCache?> {
    override fun mapToCacheModel(dto: ArticleDto?): ArticleCache {
        return ArticleCache(
            author = dto?.author,
            content = dto?.content,
            description = dto?.description,
            publishedAt = dto?.publishedAt,
            title = dto?.title.toString(),
            url = dto?.url,
            urlToImage = dto?.urlToImage,
            sourceId = dto?.source?.id,
            sourceName = dto?.source?.name
        )
    }

    override fun mapFromCacheModel(cache: ArticleCache?): ArticleDto {
        return ArticleDto(
            author = cache?.author,
            content = cache?.content,
            description = cache?.description,
            publishedAt = cache?.publishedAt,
            title = cache?.title.toString(),
            url = cache?.url,
            urlToImage = cache?.urlToImage,
            source = Source(
                id = cache?.sourceId,
                name = cache?.sourceName
            )
        )
    }

    fun toCacheList(initial: List<ArticleDto>?): List<ArticleCache> {
        initial?.let {
            return it.map { mapToCacheModel(it) }
        }
        return listOf<ArticleCache>()
    }

    fun fromCacheList(initial: List<ArticleCache>?): List<ArticleDto> {
        initial?.let {
            return it.map { mapFromCacheModel(it) }
        }
        return listOf<ArticleDto>()
    }
}