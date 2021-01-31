package com.proj.news.presentation.fragment.map

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.proj.news.domain.model.Country
import com.proj.news.presentation.fragment.map.ui.FabMapTypes
import com.proj.news.presentation.fragment.map.ui.PopulateMap

@Composable
fun PopulateMapFragmentUI(
    nav: NavController,
    countries: List<Country>?,
    mapType: Int,
    changeMapType: (Int) -> Unit,
) {
    MaterialTheme {
        Scaffold(
            floatingActionButton = { FabMapTypes(changeMapType = changeMapType) },
            bodyContent = { PopulateMap(nav = nav, countries = countries, mapType = mapType) }
        )
    }
}
