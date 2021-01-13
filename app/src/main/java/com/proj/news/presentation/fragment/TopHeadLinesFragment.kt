package com.proj.news.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.proj.news.presentation.components.*
import com.proj.news.util.DBG_TAG
import com.proj.news.viewmodel.TopHeadLinesViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TopHeadLinesFragment : Fragment() {

    private val viewModel: TopHeadLinesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Scaffold() {
                    val articles = viewModel.articles.value
                    val loading = viewModel.loading.value

                    Spacer(modifier = Modifier.padding(5.dp))

                    Box(
                        modifier = Modifier.fillMaxSize()
                            .background(MaterialTheme.colors.background)
                    ) {

                        /** listview for articles **/
                        if (loading) {

                            // display loading while its fetching result from rest api
                            LoadingArticleListAnimation(imageHeight = 250.dp)
                        } else {

                            // populate list of articles
                            LazyColumn {
                                itemsIndexed(items = articles) { index, article ->
                                    ArticleCard(article = article)
                                }
                            }
                        }


                        //TODO(create error page)
                    }
                }
            }
        }
    }
}