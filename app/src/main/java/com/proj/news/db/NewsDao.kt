package com.proj.news.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.proj.news.db.model.ArticleCache
import com.proj.news.domain.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @JvmSuppressWildcards
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<ArticleCache>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: ArticleCache?): Long
}