package com.proj.news.di

import com.proj.news.network.INewsClient
import com.proj.news.network.mapper.ArticleDtoMapper
import com.proj.news.util.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideArticleDtoMapper(): ArticleDtoMapper {
        return ArticleDtoMapper()
    }

    @Singleton
    @Provides
    fun provideNewsService(): INewsClient {
        val requestInterceptor = Interceptor { chain ->
            val url = chain.request().url().newBuilder().build()
//            Timber.d("$DBG_TAG URL: $url")
            val req = chain.request().newBuilder().url(url).build()
            return@Interceptor chain.proceed(req)
        }

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(requestInterceptor).build()

        return Retrofit.Builder()
            .baseUrl(NEWS_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(INewsClient::class.java)
    }
}