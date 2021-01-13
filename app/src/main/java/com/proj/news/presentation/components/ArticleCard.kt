package com.proj.news.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.proj.news.domain.model.Article
import com.proj.news.util.DEFAULT_News_ICON
import com.proj.news.util.loadPicture

@Composable
fun ArticleCard(
    article: Article
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(6.dp).fillMaxWidth().clickable(onClick = {}),
        elevation = 10.dp
    ) {

        Column(modifier = Modifier.padding(10.dp)) {
            article.urlToImage?.let { imgUrl ->
                val image = loadPicture(imgUrl = imgUrl, defaultImg = DEFAULT_News_ICON).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        modifier = Modifier.fillMaxWidth().preferredHeight(225.dp),
                        contentScale = ContentScale.Crop
                    )
                }

            }

            Text(
                text = article.title.toString(),
                modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start).padding(top=10.dp),
                style = MaterialTheme.typography.body1
            )

            Text(
                text = article.publishedAt.toString(),
                modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start).padding(top=6.dp),
                style = MaterialTheme.typography.body2
            )
        }

    }

}