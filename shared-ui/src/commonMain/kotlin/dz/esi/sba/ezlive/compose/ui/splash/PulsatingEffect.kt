package dz.esi.sba.ezlive.compose.ui.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale

@Composable
fun PulseEffect(
    initialPulseFraction:Float = 0.8F,
    pulseFraction: Float = 1.2F,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = initialPulseFraction,
        targetValue = pulseFraction,
        animationSpec = infiniteRepeatable(
            animation = tween(800),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = Modifier.scale(scale)
    ) {
        content()
    }
}