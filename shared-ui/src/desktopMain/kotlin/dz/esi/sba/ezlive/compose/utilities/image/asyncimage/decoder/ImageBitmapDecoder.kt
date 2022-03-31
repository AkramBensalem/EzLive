package dz.esi.sba.ezlive.compose.utilities.image.asyncimage.decoder

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import dz.esi.sba.ezlive.compose.utilities.image.core.config.ResourceConfig
import dz.esi.sba.ezlive.compose.utilities.image.core.decoder.Decoder
import io.ktor.util.*
import io.ktor.utils.io.*
import org.jetbrains.skia.Image

/**
 * Decodes and transfers [ByteReadChannel] to [ImageBitmap] using Skia [Image].
 */
internal  object ImageBitmapDecoder : Decoder<ImageBitmap> {

    override suspend fun decode(
        channel: ByteReadChannel,
        resourceConfig: ResourceConfig
    ): ImageBitmap = Image.makeFromEncoded(channel.toByteArray()).toComposeImageBitmap()

}