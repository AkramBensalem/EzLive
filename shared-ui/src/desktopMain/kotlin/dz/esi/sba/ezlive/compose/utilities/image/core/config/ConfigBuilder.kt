package dz.esi.sba.ezlive.compose.utilities.image.core.config

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import dz.esi.sba.ezlive.compose.utilities.image.core.cache.Cache
import dz.esi.sba.ezlive.compose.utilities.image.core.cache.LruCache
import dz.esi.sba.ezlive.compose.utilities.image.core.decoder.Decoder
import dz.esi.sba.ezlive.compose.utilities.image.core.fetcher.Fetcher
import dz.esi.sba.ezlive.compose.utilities.image.core.fetcher.FileFetcher
import dz.esi.sba.ezlive.compose.utilities.image.core.fetcher.HttpFetcher
import dz.esi.sba.ezlive.compose.utilities.image.core.mapper.Mapper
import dz.esi.sba.ezlive.compose.utilities.image.core.mapper.StringMapper
import dz.esi.sba.ezlive.compose.utilities.image.core.mapper.URIMapper
import dz.esi.sba.ezlive.compose.utilities.image.core.mapper.URLMapper
import io.ktor.client.*
import io.ktor.client.engine.*


public class ConfigBuilder {

    internal val fetchers: MutableList<Fetcher<Any>> = mutableListOf()

    internal val decoders: MutableList<Decoder<Any>> = mutableListOf()

    internal val mappers: MutableList<Mapper<Any, Any>> = mutableListOf()

    public var imageBitmapCacheSize: Int = 0

    public var imageVectorCacheSize: Int = 0

    public var svgCacheSize: Int = 0

    public fun <T : Any> fetcher(fetcher: Fetcher<T>) {
        fetchers += fetcher as Fetcher<Any>
    }

    public fun <T : Any> decoder(decoder: Decoder<T>) {
        decoders += decoder as Decoder<Any>
    }

    public fun <I : Any, O : Any> mapper(mapper: Mapper<I, O>) {
        mappers += mapper as Mapper<Any, Any>
    }

    public fun build(): Config = object : Config {

        override val fetchers: List<Fetcher<Any>> = this@ConfigBuilder.fetchers

        override val decoders: List<Decoder<Any>> = this@ConfigBuilder.decoders

        override val mappers: List<Mapper<Any, Any>> = this@ConfigBuilder.mappers

        override val imageBitmapCache: Cache<Any, ImageBitmap> = LruCache(imageBitmapCacheSize)

        override val imageVectorCache: Cache<Any, ImageVector> = LruCache(imageVectorCacheSize)

        override val svgCache: Cache<Any, Painter> = LruCache(svgCacheSize)
    }

}

/**
 * Adds an Http fetcher to the [KamelConfigBuilder] using the specified [engine]
 * and an optional [block] for configuring this client.
 */
public fun ConfigBuilder.httpFetcher(
    engine: HttpClientEngine,
    block: HttpClientConfig<*>.() -> Unit = {}
): Unit = fetcher(HttpFetcher(HttpClient(engine, block)))

/**
 * Adds an Http fetcher to the [KamelConfigBuilder] by loading an [HttpClientEngine] from [ServiceLoader]
 * and an optional [block] for configuring this client.
 */
public fun ConfigBuilder.httpFetcher(
    block: HttpClientConfig<*>.() -> Unit = {}
): Unit = fetcher(HttpFetcher(HttpClient(block)))

/**
 * Adds a [File] fetcher to the [KamelConfigBuilder].
 */
public fun ConfigBuilder.fileFetcher(): Unit = fetcher(FileFetcher)

/**
 * Adds a [String] to [Url] mapper to the [KamelConfigBuilder].
 */
public fun ConfigBuilder.stringMapper(): Unit = mapper(StringMapper)

/**
 * Adds a [URI] to [Url] mapper to the [KamelConfigBuilder].
 */
public fun ConfigBuilder.uriMapper(): Unit = mapper(URIMapper)

/**
 * Adds a [URL] to [Url] mapper to the [KamelConfigBuilder].
 */
public fun ConfigBuilder.urlMapper(): Unit = mapper(URLMapper)

/**
 * Copies all the data from [builder] and uses it as base for [this].
 */
public fun ConfigBuilder.takeFrom(builder: ConfigBuilder): ConfigBuilder = takeFrom(builder.build())

/**
 * Copies all the data from [config] and uses it as base for [this].
 */
public fun ConfigBuilder.takeFrom(config: Config): ConfigBuilder {
    imageBitmapCacheSize = config.imageBitmapCache.maxSize
    imageVectorCacheSize = config.imageVectorCache.maxSize
    svgCacheSize = config.svgCache.maxSize
    config.fetchers.forEach { fetcher(it) }
    config.decoders.forEach { decoder(it) }
    config.mappers.forEach { mapper(it) }

    return this
}