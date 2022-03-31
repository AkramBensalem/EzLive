package dz.esi.sba.ezlive.compose.utilities.image.core.decoder

import dz.esi.sba.ezlive.compose.utilities.image.core.config.ResourceConfig
import io.ktor.utils.io.*

/**
 * Decodes [ByteReadChannel] to [T].
 */
public interface Decoder<out T : Any> {

    /**
     * Decodes [channel] to [T].
     */
    public suspend fun decode(channel: ByteReadChannel, resourceConfig: ResourceConfig): T
}