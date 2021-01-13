package com.proj.news.presentation.components

import androidx.compose.animation.transition
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.proj.news.presentation.components.util.ShimmerAnimationDefinitions


@Composable
fun LoadingArticleListAnimation(
    imageHeight: Dp,
    padding: Dp = 16.dp,
) {

    WithConstraints() {
        val cardWidthPx = with(AmbientDensity.current) {
            ((maxWidth - (padding * 2)).toPx())
        }

        val cardHeightPx = with(AmbientDensity.current) {
            ((imageHeight - (padding)).toPx())
        }

        val cardAnimDef = remember {
            ShimmerAnimationDefinitions(
                widthPixel = cardWidthPx,
                heightPixel = cardHeightPx,
            )
        }

        val cardShimmerTranslateAnim = transition(
            definition = cardAnimDef.shimmerTransitionDefinition,
            initState = ShimmerAnimationDefinitions.AnimationState.START,
            toState = ShimmerAnimationDefinitions.AnimationState.END
        )

        val colors = listOf(
            Color.LightGray.copy(alpha = 0.9f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.9f)
        )
        val xCardShimmer = cardShimmerTranslateAnim[cardAnimDef.xShimmerPropKey]
        val yCardShimmer = cardShimmerTranslateAnim[cardAnimDef.yShimmerPropKey]

        ScrollableColumn() {
            repeat(5) {
                ShimmerArticleCardItem(
                    colors = colors,
                    cardHeight = imageHeight,
                    xShimmer = xCardShimmer,
                    yShimmer = yCardShimmer,
                    padding = padding,
                    gradientWidth = cardAnimDef.gradientWidth
                )
            }

        }


    }

}