package com.proj.news.di

import com.proj.news.network.IApiClient
import com.proj.news.network.mapper.ArticleDtoMapper
import com.proj.news.util.BASE_URL
import com.proj.news.util.CONNECT_TIMEOUT
import com.proj.news.util.DBG_TAG
import com.proj.news.util.READ_TIMEOUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideArticleDtoMapper(): ArticleDtoMapper {
        return ArticleDtoMapper()
    }

    @Singleton
    @Provides
    fun provideNewsService(): IApiClient {
        val requestInterceptor = Interceptor { chain ->
            val url = chain.request().url().newBuilder().build()
            Timber.d("$DBG_TAG URL: $url")
            val req = chain.request().newBuilder().url(url).build()
            return@Interceptor chain.proceed(req)
        }

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(requestInterceptor).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(IApiClient::class.java)
    }
}