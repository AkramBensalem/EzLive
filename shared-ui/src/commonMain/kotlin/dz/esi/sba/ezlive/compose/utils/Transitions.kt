package dz.esi.sba.ezlive.compose.utils

import androidx.compose.animation.*
import androidx.compose.animation.core.tween

@ExperimentalAnimationApi
fun scaleInEnterTransition() = scaleIn(
    initialScale = .9f,
    animationSpec = tween(800)
) + fadeIn(
    animationSpec = tween(800)
)

// Exit transition when you navigate to a screen
@ExperimentalAnimationApi
fun scaleOutExitTransition() = scaleOut(
    targetScale = 1.1f,
    animationSpec = tween(800)
) + fadeOut(
    animationSpec = tween(800)
)

@ExperimentalAnimationApi
fun scaleInPopEnterTransition() = scaleIn(
    initialScale = 1.1f,
    animationSpec = tween(300)
) + fadeIn(
    animationSpec = tween(300)
)

@ExperimentalAnimationApi
fun scaleOutPopExitTransition() = scaleOut(
    targetScale = .9f,
    animationSpec = tween(300)
) + fadeOut(
    animationSpec = tween(300)
)

