package com.proj.news.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.proj.news.db.model.ArticleCache

@Database(
    entities = [ArticleCache::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDB : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        val DB_NAME: String = "news_db"
    }
}