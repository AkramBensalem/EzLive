package dz.esi.sba.ezlive.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.KamelImage
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.lazyPainterResource

@Composable
actual fun RemoteImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier,
    contentScale: ContentScale
) {

    val imageResource = lazyPainterResource("drawable/$url")


    KamelImage(
        modifier = modifier,
        resource = imageResource,
        contentDescription =contentDescription,
        onLoading = {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        },
        onFailure = { exception ->
            Snackbar {
                exception.message?.let { Text(it) }
            }
        }
    )

}