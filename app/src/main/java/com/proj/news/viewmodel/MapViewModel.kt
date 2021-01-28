package com.proj.news.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.GoogleMap

class MapViewModel
@ViewModelInject
constructor(
) : ViewModel() {
    val mapType = mutableStateOf(GoogleMap.MAP_TYPE_NORMAL)

    fun updateMapType(changedType: Int?) {
        changedType?.let {
            mapType.value = it
        }
    }

}