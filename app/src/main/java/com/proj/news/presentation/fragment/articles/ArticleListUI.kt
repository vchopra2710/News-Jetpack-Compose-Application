package com.proj.news.presentation.fragment.articles

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.proj.news.domain.model.Article
import com.proj.news.domain.model.Country
import com.proj.news.presentation.components.*

@Composable
fun ShowArticleList(
    articles: List<Article>,
    loading: Boolean,
    query: String,
    onQueryChanged: (String) -> Unit,
    fetchTopHeadlines: (String?) -> Unit,
    countryName: String?,
    countryAlphaCode: String?,
    context: Context,
) {
    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        topBar = {
            SearchAppBar(
                query = query,
                countryName = countryName,
                countryAlphaCode = countryAlphaCode,
                onQueryChanged = onQueryChanged,
                fetchTopHeadlines = fetchTopHeadlines
            )
        }
    ) {


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
                LazyColumn {
                    itemsIndexed(items = articles) { index, article ->
                        ArticleCard(article = article, onClick = {
                            val webpage = Uri.parse(article.url)
                            val intent = Intent(Intent.ACTION_VIEW, webpage)
                            context.startActivity(intent)
                        })
                    }
                }

                //TODO(create error page)
                /*if (articles.isNotEmpty()) {
                    if (articles[0].exception == null) {
                        // populate list of articles
                        LazyColumn {
                            itemsIndexed(items = articles) { index, article ->
                                ArticleCard(article = article)
                            }
                        }
                    } else {
                        Timber.d("$DBG_TAG ${articles[0].exception?.message}")
                    }
                }*/

            }
        }
    }
}