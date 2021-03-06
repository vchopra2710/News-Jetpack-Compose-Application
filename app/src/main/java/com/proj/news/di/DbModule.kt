package com.proj.news.di

import android.content.Context
import androidx.room.Room
import com.proj.news.db.NewsDB
import com.proj.news.db.NewsDao
import com.proj.news.db.mapper.article.ArticleCacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideArticleCacheMapper(): ArticleCacheMapper {
        return ArticleCacheMapper()
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext context: Context): NewsDB {
        return Room.databaseBuilder(
            context,
            NewsDB::class.java,
            NewsDB.DB_NAME
        ).fallbackToDestructiveMigration().build()
    }


    @Provides
    @Singleton
    fun provideNewsDao(newsDB: NewsDB): NewsDao {
        return newsDB.newsDao()
    }
}