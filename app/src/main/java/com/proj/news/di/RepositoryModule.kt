package com.proj.news.di

import com.proj.news.db.NewsDao
import com.proj.news.db.mapper.article.ArticleCacheMapper
import com.proj.news.network.INewsClient
import com.proj.news.network.mapper.ArticleDtoMapper
import com.proj.news.repository.IMainRepository
import com.proj.news.repository.MainRepositoryImpl
import com.proj.news.repository.news.INewsRepository
import com.proj.news.repository.news.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        newsRepository: INewsRepository
    ): IMainRepository {
        return MainRepositoryImpl(newsRepository)
    }

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsApiClient: INewsClient,
        articleDtoMapper: ArticleDtoMapper,
        articleCacheMapper: ArticleCacheMapper,
        newsDao: NewsDao
    ): INewsRepository {
        return NewsRepositoryImpl(newsApiClient, articleDtoMapper, articleCacheMapper, newsDao)
    }
}