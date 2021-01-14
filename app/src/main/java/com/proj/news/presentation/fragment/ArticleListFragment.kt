package com.proj.news.presentation.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.proj.news.R
import com.proj.news.viewmodel.TopHeadLinesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListFragment : Fragment() {

    private val viewModel: TopHeadLinesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }
}