package dz.esi.sba.ezlive.compose.utilities.image.core.config

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import dz.esi.sba.ezlive.compose.utilities.image.core.cache.Cache
import dz.esi.sba.ezlive.compose.utilities.image.core.decoder.Decoder
import dz.esi.sba.ezlive.compose.utilities.image.core.fetcher.Fetcher
import dz.esi.sba.ezlive.compose.utilities.image.core.mapper.Mapper

public const val DefaultCacheSize: Int = 100

@Deprecated("Deprecated in favor of DefaultCacheSize.")
public const val DefaultImageBitmapCacheSize: Int = DefaultCacheSize

/**
 * Represents global configuration for this library.
 * @see KamelConfig to configure one.
 */
public interface Config {

    public val fetchers: List<Fetcher<Any>>

    public val decoders: List<Decoder<Any>>

    public val mappers: List<Mapper<Any, Any>>

    /**
     * Number of entries to cache. Default is 100.
     */
    public val imageBitmapCache: Cache<Any, ImageBitmap>

    public val imageVectorCache: Cache<Any, ImageVector>

    public val svgCache: Cache<Any, Painter>

    public companion object
}

/**
 * Configures [KamelConfig] using [KamelConfigBuilder].
 */
public inline fun Config(block: ConfigBuilder.() -> Unit): Config =
    ConfigBuilder().apply(block).build()