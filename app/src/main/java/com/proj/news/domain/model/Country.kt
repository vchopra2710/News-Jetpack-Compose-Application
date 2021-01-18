package com.proj.news.domain.model

import androidx.annotation.DrawableRes
import com.google.android.gms.maps.model.LatLng

data class Country(
    val name: String,
    val latLng: LatLng,
    val alpha2Code: String,
    val focused: Boolean = false,
    @DrawableRes val resId: Int?
)