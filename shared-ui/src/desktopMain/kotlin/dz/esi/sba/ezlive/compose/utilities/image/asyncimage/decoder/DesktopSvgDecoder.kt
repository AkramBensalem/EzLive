package dz.esi.sba.ezlive.compose.utilities.image.asyncimage.decoder

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.loadSvgPainter
import dz.esi.sba.ezlive.compose.utilities.image.core.config.ResourceConfig
import dz.esi.sba.ezlive.compose.utilities.image.core.decoder.Decoder
import io.ktor.utils.io.*
import io.ktor.utils.io.jvm.javaio.*

internal object SvgDecoder : Decoder<Painter> {
    override suspend fun decode(channel: ByteReadChannel, resourceConfig: ResourceConfig): Painter {
        return loadSvgPainter(
            channel.toInputStream(),
            resourceConfig.density
        )
    }
}