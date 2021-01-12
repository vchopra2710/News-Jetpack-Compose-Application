package com.proj.news.events

import java.lang.Exception

sealed class DataStateEvent<out R> {
    data class Success<out T>(val data: T) : DataStateEvent<T>()
    data class Error(val exception: Exception) : DataStateEvent<Nothing>()
    object Loading : DataStateEvent<Nothing>()
}