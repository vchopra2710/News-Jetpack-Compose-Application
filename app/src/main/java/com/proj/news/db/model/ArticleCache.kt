package com.proj.news.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleCache(
//    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "articleId") val articleId: Long = 0L,
    @ColumnInfo(name = "author") val author: String?,
    @ColumnInfo(name = "content") val content: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "publishedAt") val publishedAt: String?,
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "title") val title: String = "title",
    @ColumnInfo(name = "url") val url: String?,
    @ColumnInfo(name = "urlToImage") val urlToImage: String?,
    @ColumnInfo(name = "sourceId") val sourceId: String?,
    @ColumnInfo(name = "sourceName") val sourceName: String?
)