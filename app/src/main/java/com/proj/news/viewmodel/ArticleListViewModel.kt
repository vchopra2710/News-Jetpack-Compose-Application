package com.proj.news.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.proj.news.domain.model.Article
import com.proj.news.events.MainStateEvent
import com.proj.news.repository.IMainRepository
import com.proj.news.util.DEFAULT_SEARCH_COUNTRY_ALPHA_CODE
import kotlinx.coroutines.launch

class ArticleListViewModel
@ViewModelInject
constructor(
    private val repository: IMainRepository
) : ViewModel() {

    val articles: MutableState<List<Article>> = mutableStateOf(listOf<Article>())
    val loading: MutableState<Boolean> = mutableStateOf(false)
    val query = mutableStateOf("")

    fun fetchTopHeadlines(
        countryAlphaCode: String? = DEFAULT_SEARCH_COUNTRY_ALPHA_CODE
    ) {
        getStateEvent(
            mainStateEvent = MainStateEvent.FetchTopHeadlines,
            query = query.value,
            country = countryAlphaCode,
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