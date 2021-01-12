package com.proj.news.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.proj.news.domain.model.Article
import com.proj.news.events.DataStateEvent
import com.proj.news.events.MainStateEvent
import com.proj.news.repository.INewsRepository
import com.proj.news.util.DBG_TAG
import com.proj.news.util.DEFAULT_SEARCH_COUNTRY
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber

class TopHeadLinesViewModel
@ViewModelInject
constructor(
    private val repository: INewsRepository
) : ViewModel() {

    private val _dataStateRequestTopHeadlines: MutableLiveData<DataStateEvent<Boolean>> =
        MutableLiveData()
    val dataStateRequestTopHeadlines: LiveData<DataStateEvent<Boolean>>
        get() = _dataStateRequestTopHeadlines

    val domainArticleBlog: LiveData<List<Article>> = repository.getTopHeadLinesFromDB().asLiveData()

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines(country: String? = DEFAULT_SEARCH_COUNTRY) {
        Timber.d("$DBG_TAG query: $country")
        getStateEvent(
            mainStateEvent = MainStateEvent.FetchTopHeadlines,
            country = country,
        )
    }

    private fun getStateEvent(
        mainStateEvent: MainStateEvent?,
        country: String?
    ) {
        mainStateEvent?.let { event ->
            viewModelScope.launch {
                when (event) {

                    is MainStateEvent.FetchTopHeadlines -> {
                        repository.fetchTopHeadLines(country).onEach {
                            _dataStateRequestTopHeadlines.value = it
                        }.launchIn(viewModelScope)
                    }
                }
            }
        }
    }
}