package com.proj.news.events

sealed class MainStateEvent {
    object FetchTopHeadlines : MainStateEvent()
    object None : MainStateEvent()
}