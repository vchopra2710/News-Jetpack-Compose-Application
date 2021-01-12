package com.proj.news.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.proj.news.R
import com.proj.news.databinding.FragmentTopHeadLinesBinding
import com.proj.news.events.DataStateEvent
import com.proj.news.events.DataStateEvent.Loading
import com.proj.news.events.DataStateEvent.Error
import com.proj.news.events.DataStateEvent.Success
import com.proj.news.util.DBG_TAG
import com.proj.news.viewmodel.TopHeadLinesViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TopHeadLinesFragment : Fragment(R.layout.fragment_top_head_lines) {

    private val viewModel: TopHeadLinesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding: FragmentTopHeadLinesBinding =
            DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_top_head_lines)
        observeApi()
        observeDatabase()
    }

    private fun observeApi() {
        viewModel.dataStateRequestTopHeadlines.observe(viewLifecycleOwner, Observer { event ->
            when (event) {
                is Loading -> {
                    Timber.d("$DBG_TAG getting data from api")
                }
                is Success<Boolean> -> {
                    val venueFetched: Boolean = event.data
                    Timber.d("$DBG_TAG got data from api => ${venueFetched}")
                }
                is Error -> {
                    Timber.d("$DBG_TAG error getting data from api: ${event.exception.toString()}")
                    // TODO: update ui(error page)
                }
            }
        })
    }

    private fun observeDatabase() {
        viewModel.domainArticleBlog.observe(viewLifecycleOwner, Observer { articles ->
            if (articles.isEmpty()) return@Observer
            Timber.d("$DBG_TAG, size : ${articles.size}")
            /*for (article in articles) {
                Timber.d("$DBG_TAG, ${articles.indexOf(article)} => ${article.title}")
            }*/
        })
    }
}