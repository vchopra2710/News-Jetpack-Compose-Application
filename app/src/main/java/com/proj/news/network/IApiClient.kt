package com.proj.news.network

import com.proj.news.network.model.articles.TopHeadLinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiClient {

    /**
     *
     *https://newsapi.org/v2/top-headlines?country=COUNTRY_CODE&apiKey=API_KEY
     **/
    @GET("v2/top-headlines")
    suspend fun fetchTopHeadLines(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?,
    ): TopHeadLinesResponse
}