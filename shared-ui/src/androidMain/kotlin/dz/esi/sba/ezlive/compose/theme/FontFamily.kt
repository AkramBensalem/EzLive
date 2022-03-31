package dz.esi.sba.ezlive.compose.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import dz.esi.sba.ezlive.shared_ui.R

actual fun Merryweather(): FontFamily = FontFamily(
    Font(
        resId = R.font.merriweather_regular,
        weight = FontWeight.W400,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.merriweather_italic,
        weight = FontWeight.W400,
        style = FontStyle.Italic
    ),

    Font(
        resId = R.font.merriweather_light,
        weight = FontWeight.W200,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.merriweather_lightitalic,
        weight = FontWeight.W200,
        style = FontStyle.Italic
    ),

    Font(
        resId = R.font.merriweather_bold,
        weight = FontWeight.W700,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.merriweather_bolditalic,
        weight = FontWeight.W700,
        style = FontStyle.Italic
    ),


    Font(
        resId = R.font.merriweather_black,
        weight = FontWeight.W900,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.merriweather_blackitalic,
        weight = FontWeight.W900,
        style = FontStyle.Italic
    )
    )