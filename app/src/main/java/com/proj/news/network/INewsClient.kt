package com.proj.news.network

import com.proj.news.network.model.articles.TopHeadLinesResponse
import com.proj.news.util.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiClient {

    /**
     *
     *https://newsapi.org/v2/top-headlines?country=COUNTRY_CODE&apiKey=API_KEY
     * [q]: query to search in your country
     * [country]: which country news you are looking for
     * [apikey]: auth key to response from api
     **/
    @GET("v2/top-headlines")
    suspend fun fetchTopHeadLines(
        @Query("q") query: String?,
        @Query("country") country: String?,
        @Query("language") language: String?="en",
        @Query("apiKey") apiKey: String? = API_KEY,
    ): TopHeadLinesResponse
}