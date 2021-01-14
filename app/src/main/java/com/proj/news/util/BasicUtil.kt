package com.proj.news.util

import android.os.Build
import android.text.Html
import android.text.Spanned
import com.proj.news.domain.model.Article
import java.lang.StringBuilder

fun buildArticleCardDesc(article: Article): Spanned {
    val description =
        if (article.content.isNullOrEmpty()) article.description.toString() else article.content.toString()
    val sb = StringBuilder().apply {
        append(description)
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        return Html.fromHtml(sb.toString())
    }
}