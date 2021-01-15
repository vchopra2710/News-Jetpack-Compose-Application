package com.proj.news.presentation.fragment.articles

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.proj.news.viewmodel.ArticleListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListFragment : Fragment() {

    private val viewModel: ArticleListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {

            setContent {
                val articles = viewModel.articles.value
                val loading = viewModel.loading.value
                val query = viewModel.query.value

                ShowArticleList(
                    articles = articles, loading = loading, query = query,
                    onQueryChanged = viewModel::onQueryChanged,
                    fetchTopHeadlines = viewModel::fetchTopHeadlines,
                    context = requireContext()
                )
            }
        }
    }
}