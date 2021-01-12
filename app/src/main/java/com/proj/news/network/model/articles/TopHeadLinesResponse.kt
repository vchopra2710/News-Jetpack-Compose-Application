package com.proj.news.network.model.articles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopHeadLinesResponse(
    @SerializedName("articles") @Expose val articles: List<ArticleDto>?,
    @SerializedName("status") @Expose val status: String?,
    @SerializedName("itotalResultsd") @Expose val totalResults: Int?
)