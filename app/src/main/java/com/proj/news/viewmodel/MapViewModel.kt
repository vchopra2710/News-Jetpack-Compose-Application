package com.proj.news.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.GoogleMap
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel
@Inject
constructor() : ViewModel() {
    val mapType = mutableStateOf(GoogleMap.MAP_TYPE_NORMAL)

    fun updateMapType(changedType: Int?) {
        changedType?.let {
            mapType.value = it
        }
    }

}