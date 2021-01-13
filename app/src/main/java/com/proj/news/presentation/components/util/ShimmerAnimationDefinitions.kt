package com.proj.news.presentation.components.util

import androidx.compose.animation.core.*
import com.proj.news.presentation.components.util.ShimmerAnimationDefinitions.AnimationState.END
import com.proj.news.presentation.components.util.ShimmerAnimationDefinitions.AnimationState.START

class ShimmerAnimationDefinitions(
    private val widthPixel: Float,
    private val heightPixel: Float
) {
    var gradientWidth: Float

    init {
        gradientWidth = 0.2f * heightPixel

    }

    enum class AnimationState {
        START, END
    }

    val xShimmerPropKey = FloatPropKey("xShimmer")
    val yShimmerPropKey = FloatPropKey("yShimmer")

    val shimmerTransitionDefinition = transitionDefinition<AnimationState> {
        state(START) {
            this[xShimmerPropKey] = 0f
            this[yShimmerPropKey] = 0f
        }
        state(END) {
            this[xShimmerPropKey] = widthPixel + gradientWidth
            this[yShimmerPropKey] = heightPixel + gradientWidth
        }

        transition(START, END) {
            xShimmerPropKey using infiniteRepeatable(
                animation = tween(
                    durationMillis = 1300,
                    delayMillis = 300,
                    easing = LinearEasing
                )
            )
            yShimmerPropKey using infiniteRepeatable(
                animation = tween(
                    durationMillis = 1300,
                    delayMillis = 300,
                    easing = LinearEasing
                )
            )
        }
    }
}