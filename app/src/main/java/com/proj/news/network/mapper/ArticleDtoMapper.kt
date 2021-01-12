package com.proj.news.network.mapper

import com.proj.news.domain.mapper.DomainMapper
import com.proj.news.domain.model.Article
import com.proj.news.network.model.articles.ArticleDto
import com.proj.news.network.model.articles.Source

class ArticleDtoMapper : DomainMapper<ArticleDto?, Article?> {
    override fun mapToDomainModel(model: ArticleDto?): Article {
        return Article(
            author = model?.author,
            content = model?.content,
            description = model?.description,
            publishedAt = model?.publishedAt,
            title = model?.title,
            url = model?.url,
            urlToImage = model?.urlToImage,
            sourceId = model?.source?.id,
            sourceName = model?.source?.name
        )
    }

    override fun mapFromDomainModel(domainModel: Article?): ArticleDto {
        return ArticleDto(
            author = domainModel?.author,
            content = domainModel?.content,
            description = domainModel?.description,
            publishedAt = domainModel?.publishedAt,
            title = domainModel?.title,
            url = domainModel?.url,
            urlToImage = domainModel?.urlToImage,
            source = Source(
                id = domainModel?.sourceId,
                name = domainModel?.sourceName
            )
        )
    }


    fun toDomainList(initial: List<ArticleDto>?): List<Article> {
        initial?.let {
            return it.map { mapToDomainModel(it) }
        }
        return listOf<Article>()
    }

    fun fromDomainList(initial: List<Article>?): List<ArticleDto> {
        initial?.let {
            return it.map { mapFromDomainModel(it) }
        }
        return listOf<ArticleDto>()
    }
}