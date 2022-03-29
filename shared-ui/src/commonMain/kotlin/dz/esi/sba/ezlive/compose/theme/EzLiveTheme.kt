package dz.esi.sba.ezlive.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun EzLiveTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        darkColors()
            .copy(
                primary = primaryDarkColor,
                primaryVariant = primaryLightColor,
                secondary = secondaryDarkColor,
                secondaryVariant = secondaryLightColor,
                onPrimary = Color.White,
                background = lightGrey,
                onSurface = lightGrey
            )
    } else {
        lightColors()
            .copy(
                primary = primaryColor,
                primaryVariant = primaryLightColor,
                secondary = secondaryColor,
                secondaryVariant = secondaryLightColor,
                onPrimary = Color.Black,
                background = Color.White
            )
    }
    MaterialTheme(
        colors = colors,
        typography = typography,
        content = content
    )
}