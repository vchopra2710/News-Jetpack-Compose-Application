package com.proj.news.util

import android.os.Build
import android.text.Html
import android.text.Spanned
import com.google.android.gms.maps.model.LatLng
import com.proj.news.domain.model.Article
import com.proj.news.domain.model.Country
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

fun buildCountryList(): List<Country> {
    val _list = mutableListOf<Country>()
    _list.add(
        Country(
            name = "United Arab Emirates",
            latLng = LatLng(23.74706513103169, 53.94793064072641),
            alpha2Code = "ae"
        )
    )
    _list.add(
        Country(
            name = "Argentina",
            latLng = LatLng(-35.284070031112726, -65.00889116499565),
            alpha2Code = "ar"
        )
    )
    _list.add(
        Country(
            name = "Austria",
            latLng = LatLng(47.59318039059475, 14.102173771048346),
            alpha2Code = "at"
        )
    )
    _list.add(
        Country(
            name = "Belgium",
            latLng = LatLng(50.500937920163814, 4.817252786225892),
            alpha2Code = "be"
        )
    )
    _list.add(
        Country(
            name = "Bulgaria",
            latLng = LatLng(42.52561691248744, 25.035955182873213),
            alpha2Code = "bg"
        )
    )
    _list.add(
        Country(
            name = "Brazil",
            latLng = LatLng(-8.356589049708392, -54.47251172422005),
            alpha2Code = "br"
        )
    )
    _list.add(
        Country(
            name = "India",
            latLng = LatLng(29.300072238354698, 77.23742007095115),
            alpha2Code = "in", true
        )
    )
    _list.add(
        Country(
            name = "USA",
            latLng = LatLng(44.81159925567629, -107.91675933389449),
            alpha2Code = "us"
        )
    )
    _list.add(
        Country(
            name = "Canada",
            latLng = LatLng(60.221894150361386, -111.67569780365353),
            alpha2Code = "ca"
        )
    )
    _list.add(
        Country(
            name = "Switzerland",
            latLng = LatLng(46.79079316993678, 8.366566046383156),
            alpha2Code = "ch"
        )
    )
    _list.add(
        Country(
            name = "China",
            latLng = LatLng(34.993475160072926, 103.5445201808688),
            alpha2Code = "cn"
        )
    )
    _list.add(
        Country(
            name = "Colombia",
            latLng = LatLng(3.360434451796628, -73.19005649278392),
            alpha2Code = "co"
        )
    )
    _list.add(
        Country(
            name = "Cuba",
            latLng = LatLng(21.577748210736104, -78.98307251771453),
            alpha2Code = "cu"
        )
    )
    return _list
}