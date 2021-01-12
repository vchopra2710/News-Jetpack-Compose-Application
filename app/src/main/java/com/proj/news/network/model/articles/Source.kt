package com.proj.news.network.model.articles

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id") @Expose val id: String?,
    @SerializedName("name") @Expose val name: String?
)