package com.proj.news.di

import com.proj.news.db.NewsDao
import com.proj.news.db.mapper.ArticleCacheMapper
import com.proj.news.network.IApiClient
import com.proj.news.network.mapper.ArticleDtoMapper
import com.proj.news.repository.INewsRepository
import com.proj.news.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideArtRepository(
        apiClient: IApiClient,
        articleDtoMapper: ArticleDtoMapper,
        articleCacheMapper: ArticleCacheMapper,
        newsDao: NewsDao
    ): INewsRepository {
        return NewsRepositoryImpl(
            apiClient,
            articleDtoMapper, articleCacheMapper,
            newsDao
        )
    }
}