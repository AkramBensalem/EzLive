package dz.esi.sba.ezlive.compose

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dz.esi.sba.ezlive.shared_ui.R

@Composable
actual fun RemoteImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier,
    contentScale: ContentScale
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(getResId(url) ?: url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.logo),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )

}


private fun getResId(url : String) = when(url){
    "logo.png" -> R.drawable.logo
    else -> null
}
