package com.proj.news.presentation.components.util

import androidx.compose.animation.DpPropKey
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.dp
import com.proj.news.presentation.components.util.FabAnimationDefinition.FabState.EXPLODED
import com.proj.news.presentation.components.util.FabAnimationDefinition.FabState.IDLE

object FabAnimationDefinition {
    enum class FabState {
        IDLE, EXPLODED
    }

    val width = DpPropKey()
    val height = DpPropKey()

    val fabTransitionDefinition = transitionDefinition<FabState> {
        state(IDLE) {
            this[width] = 60.dp
            this[height] = 60.dp
        }
        state(EXPLODED) {
            this[width] = 60.dp
            this[height] = 320.dp
        }

        transition(fromState = IDLE, toState = EXPLODED) {
            width using tween(durationMillis = 700)
            height using tween(durationMillis = 700)
        }

    }
}