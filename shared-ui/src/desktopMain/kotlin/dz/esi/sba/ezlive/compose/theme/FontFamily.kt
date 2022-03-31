package dz.esi.sba.ezlive.compose.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

actual fun Merryweather(): FontFamily  = FontFamily(
        Font(
            resource = "font/merriweather_regular.ttf",
            weight = FontWeight.W400,
            style = FontStyle.Normal
        ),
        Font(
            resource = "font/merriweather_italic.ttf",
            weight = FontWeight.W400,
            style = FontStyle.Italic
        ),

        Font(
            resource = "font/merriweather_light.ttf",
            weight = FontWeight.W200,
            style = FontStyle.Normal
        ),
        Font(
            resource = "font/merriweather_lightitalic.ttf",
            weight = FontWeight.W200,
            style = FontStyle.Italic
        ),

        Font(
            resource = "font/merriweather_bold.ttf",
            weight = FontWeight.W700,
            style = FontStyle.Normal
        ),
        Font(
            resource = "font/merriweather_bolditalic.ttf",
            weight = FontWeight.W700,
            style = FontStyle.Italic
        ),


        Font(
            resource = "font/merriweather_black.ttf",
            weight = FontWeight.W900,
            style = FontStyle.Normal
        ),
        Font(
            resource = "font/merriweather_blackitalic.ttf",
            weight = FontWeight.W900,
            style = FontStyle.Italic
        )
    )