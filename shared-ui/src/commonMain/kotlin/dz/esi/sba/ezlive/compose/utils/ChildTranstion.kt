package dz.esi.sba.ezlive.compose.utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.ChildAnimation

@OptIn(ExperimentalAnimationApi::class)
internal fun <C : Any, T : Any> CustomScaleChildAnimation(): ChildAnimation<C, T> =
    { routerState, modifier, childContent ->
        AnimatedVisibility(
            visible = true,
            enter = scaleInEnterTransition(),
            exit = scaleOutExitTransition(),
            modifier = modifier
            ){
            childContent(routerState.activeChild)
        }
    }
