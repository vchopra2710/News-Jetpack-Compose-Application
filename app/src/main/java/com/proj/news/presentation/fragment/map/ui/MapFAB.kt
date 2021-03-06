package com.proj.news.presentation.fragment.map.ui

import android.content.Context
import androidx.compose.animation.transition
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.GoogleMap
import com.proj.news.presentation.components.util.FabAnimationDefinition.FabState.*
import com.proj.news.presentation.components.util.FabAnimationDefinition.fabTransitionDefinition
import com.proj.news.presentation.components.util.FabAnimationDefinition.height
import com.proj.news.presentation.components.util.FabAnimationDefinition.width
import com.proj.news.util.FAB_MAX_HEIGHT

@Composable
fun FabMapTypes(
    ctx: Context = AmbientContext.current,
    changeMapType: (Int) -> Unit,
) {
    val fabState = remember { mutableStateOf(false) }
    val state = transition(
        definition = fabTransitionDefinition,
        initState = IDLE,
        toState = if (fabState.value) EXPLODED else IDLE,
        onStateChangeFinished = {
            // when animation is completed
        }
    )

    FloatingActionButton(
        onClick = { /*fabState.value = !fabState.value*/ },
        modifier = Modifier
            .width(state[width])
            .height(state[height]),
    ) {
        if (!fabState.value) {
            IconButton(onClick = { fabState.value = !fabState.value }) {
                Icon(Icons.Default.ArrowUpward)
            }
        } else {
            Column(
                modifier = Modifier.height(FAB_MAX_HEIGHT.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {

                IconButton(onClick = { changeMapType(GoogleMap.MAP_TYPE_SATELLITE) }) {
                    Icon(Icons.Filled.Satellite)
                }

                IconButton(onClick = { changeMapType(GoogleMap.MAP_TYPE_TERRAIN) }) {
                    Icon(Icons.Filled.Terrain)
                }

                IconButton(onClick = { changeMapType(GoogleMap.MAP_TYPE_HYBRID) }) {
                    Icon(Icons.Filled.MapsUgc)
                }

                IconButton(onClick = { fabState.value = !fabState.value }) {
                    Icon(Icons.Filled.ArrowDownward)
                }
            }
        }
    }
}