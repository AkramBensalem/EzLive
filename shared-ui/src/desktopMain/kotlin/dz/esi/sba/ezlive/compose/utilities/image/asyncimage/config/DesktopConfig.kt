package dz.esi.sba.ezlive.compose.utilities.image.asyncimage.config

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.decoder.ImageBitmapDecoder
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.decoder.ImageVectorDecoder
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.decoder.SvgDecoder
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.fetcher.ResourcesFetcher
import dz.esi.sba.ezlive.compose.utilities.image.core.config.*

/**
 * Adds application resources fetcher to the [KamelConfigBuilder].
 */
public fun ConfigBuilder.resourcesFetcher(): Unit = fetcher(ResourcesFetcher)

public fun ConfigBuilder.imageVectorDecoder(): Unit = decoder(ImageVectorDecoder)

public fun ConfigBuilder.svgDecoder(): Unit = decoder(SvgDecoder)



public val Config.Companion.Default: Config
    get() = Config {
        imageBitmapCacheSize = DefaultCacheSize
        imageVectorCacheSize = DefaultCacheSize
        imageBitmapDecoder()
        stringMapper()
        urlMapper()
        uriMapper()
        fileFetcher()
        httpFetcher()
    }

/**
 * Adds an [ImageBitmap] decoder to the [KamelConfigBuilder].
 */
public fun ConfigBuilder.imageBitmapDecoder(): Unit = decoder(ImageBitmapDecoder)

/**
 * Static CompositionLocal that provides the default configuration of [KamelConfig].
 */
public val LocalKamelConfig: ProvidableCompositionLocal<Config> = staticCompositionLocalOf { Config.Default }