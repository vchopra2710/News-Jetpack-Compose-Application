package com.proj.news.util

import android.os.Build
import android.text.Html
import android.text.Spanned
import com.google.android.gms.maps.model.LatLng
import com.proj.news.R
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
            alpha2Code = "ae",
            resId = R.drawable.ic_ae
        )
    )
    _list.add(
        Country(
            name = "Argentina",
            latLng = LatLng(-35.284070031112726, -65.00889116499565),
            alpha2Code = "ar",
            resId = R.drawable.ic_ar
        )
    )
    _list.add(
        Country(
            name = "Austria",
            latLng = LatLng(47.59318039059475, 14.102173771048346),
            alpha2Code = "at",
            resId = R.drawable.ic_at
        )
    )
    _list.add(
        Country(
            name = "Belgium",
            latLng = LatLng(50.500937920163814, 4.817252786225892),
            alpha2Code = "be",
            resId = R.drawable.ic_be
        )
    )
    _list.add(
        Country(
            name = "Bulgaria",
            latLng = LatLng(42.52561691248744, 25.035955182873213),
            alpha2Code = "bg",
            resId = R.drawable.ic_bg
        )
    )
    _list.add(
        Country(
            name = "Brazil",
            latLng = LatLng(-8.356589049708392, -54.47251172422005),
            alpha2Code = "br",
            resId = R.drawable.ic_br
        )
    )
    _list.add(
        Country(
            name = "India",
            latLng = LatLng(29.300072238354698, 77.23742007095115),
            alpha2Code = "in", true,
            resId = R.drawable.ic_in
        )
    )
    _list.add(
        Country(
            name = "USA",
            latLng = LatLng(44.81159925567629, -107.91675933389449),
            alpha2Code = "us",
            resId = R.drawable.ic_us
        )
    )
    _list.add(
        Country(
            name = "Canada",
            latLng = LatLng(60.221894150361386, -111.67569780365353),
            alpha2Code = "ca",
            resId = R.drawable.ic_ca
        )
    )
    _list.add(
        Country(
            name = "Switzerland",
            latLng = LatLng(46.79079316993678, 8.366566046383156),
            alpha2Code = "ch",
            resId = R.drawable.ic_ch
        )
    )
    _list.add(
        Country(
            name = "China",
            latLng = LatLng(34.993475160072926, 103.5445201808688),
            alpha2Code = "cn",
            resId = R.drawable.ic_cn
        )
    )
    _list.add(
        Country(
            name = "Colombia",
            latLng = LatLng(3.360434451796628, -73.19005649278392),
            alpha2Code = "co",
            resId = R.drawable.ic_co
        )
    )
    _list.add(
        Country(
            name = "Cuba",
            latLng = LatLng(21.577748210736104, -78.98307251771453),
            alpha2Code = "cu",
            resId = R.drawable.ic_cu
        )
    )
    _list.add(
        Country(
            name = "Czechia",
            latLng = LatLng(50.07093831326505, 14.44283240844085),
            alpha2Code = "cz",
            resId = R.drawable.ic_launcher_foreground
        )
    )
    _list.add(
        Country(
            name = "Germany",
            latLng = LatLng(50.84083023647146, 10.054801475474456),
            alpha2Code = "de",
            resId = R.drawable.ic_de
        )
    )
    _list.add(
        Country(
            name = "Egypt",
            latLng = LatLng(26.841449258547254, 29.859159560587873),
            alpha2Code = "eg",
            resId = R.drawable.ic_eg
        )
    )
    _list.add(
        Country(
            name = "France",
            latLng = LatLng(46.7220331638811, 2.309714663963177),
            alpha2Code = "fr",
            resId = R.drawable.ic_fr
        )
    )
    _list.add(
        Country(
            name = "United Kingdom",
            latLng = LatLng(55.308664189329264, -3.0597779373774934),
            alpha2Code = "gb",
            resId = R.drawable.ic_launcher_foreground
        )
    )

    return _list
}