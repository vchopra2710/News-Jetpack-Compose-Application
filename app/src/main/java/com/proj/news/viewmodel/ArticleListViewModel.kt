package com.proj.news.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.proj.news.domain.model.Article
import com.proj.news.events.MainStateEvent
import com.proj.news.repository.INewsRepository
import com.proj.news.util.DBG_TAG
import com.proj.news.util.DEFAULT_SEARCH_COUNTRY
import kotlinx.coroutines.launch
import timber.log.Timber

class ArticleListViewModel
@ViewModelInject
constructor(
    private val repository: INewsRepository
) : ViewModel() {

    val articles: MutableState<List<Article>> = mutableStateOf(listOf<Article>())
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val query = mutableStateOf("")

    init {
        fetchTopHeadlines()
    }

    fun fetchTopHeadlines(
        country: String? = DEFAULT_SEARCH_COUNTRY
    ) {
        getStateEvent(
            mainStateEvent = MainStateEvent.FetchTopHeadlines,
            query = query.value,
            country = country,
        )
    }

    fun onQueryChanged(newVal: String?) {
        newVal?.let {
            query.value = it
        }
    }

    private fun getStateEvent(
        mainStateEvent: MainStateEvent?,
        query: String?,
        country: String?
    ) {
        mainStateEvent?.let { event ->
            viewModelScope.launch {
                loading.value = true
                when (event) {

                    is MainStateEvent.FetchTopHeadlines -> {
                        articles.value = repository.fetchTopHeadLines(query, country)
                    }
                }
                loading.value = false
            }
        }
    }
}