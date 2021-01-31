package com.proj.news.presentation.components.util

import androidx.compose.animation.DpPropKey
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.dp
import com.proj.news.presentation.components.util.FabAnimationDefinition.FabState.EXPLODED
import com.proj.news.presentation.components.util.FabAnimationDefinition.FabState.IDLE
import com.proj.news.util.FAB_MAX_HEIGHT
import com.proj.news.util.FAB_MAX_WIDTH

object FabAnimationDefinition {
    enum class FabState {
        IDLE, EXPLODED
    }

    val width = DpPropKey()
    val height = DpPropKey()

    val fabTransitionDefinition = transitionDefinition<FabState> {
        state(IDLE) {
            this[width] = FAB_MAX_WIDTH.dp
            this[height] = FAB_MAX_WIDTH.dp
        }
        state(EXPLODED) {
            this[width] = FAB_MAX_WIDTH.dp
            this[height] = FAB_MAX_HEIGHT.dp
        }

        transition(fromState = IDLE, toState = EXPLODED) {
            width using tween(durationMillis = 500)
            height using tween(durationMillis = 500)
        }
    }
}