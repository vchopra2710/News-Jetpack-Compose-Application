package com.proj.news.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar() {
    BottomNavigation(elevation = 10.dp) {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.ReadMore) },
            selected = false,
            onClick = { })
        BottomNavigationItem(
            icon = { Icon(Icons.Default.LocalHospital) },
            selected = false,
            onClick = { })
    }
}