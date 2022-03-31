package dz.esi.sba.ezlive.compose.utilities.image.core.utils

import dz.esi.sba.ezlive.compose.utilities.image.core.config.Config
import dz.esi.sba.ezlive.compose.utilities.image.core.decoder.Decoder
import dz.esi.sba.ezlive.compose.utilities.image.core.fetcher.Fetcher
import kotlin.reflect.full.createType
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.full.isSupertypeOf
import kotlin.reflect.typeOf


internal fun Config.mapInput(input: Any): Any {

    var output: Any? = null

    mappers.findLast {

        output = try {
            it.map(input)
        } catch (e: Throwable) {
            null
        }

        output != null
    }

    return output ?: input
}






internal  fun <T : Any> Config.findFetcherFor(data: T): Fetcher<T> {

    val type = data::class.createType()

    val fetcher = fetchers.findLast { fetcher ->

        val fetcherType = fetcher::class.supertypes
            .firstOrNull()
            ?.arguments
            ?.firstOrNull()
            ?.type ?: error("Unable to find type for $fetcher")

        val isSameType = fetcherType.isSupertypeOf(type) || fetcherType.isSubtypeOf(type)

        isSameType && with(fetcher) { data.isSupported }
    }

    checkNotNull(fetcher) { "Unable to find a fetcher for $type" }

    return fetcher as Fetcher<T>
}

@OptIn(ExperimentalStdlibApi::class)
internal inline fun <reified T : Any> Config.findDecoderFor(): Decoder<T> {

    val type = typeOf<Decoder<T>>()

    val decoder = decoders.findLast { decoder ->

        val decoderType = decoder::class.createType()

        decoderType.isSupertypeOf(type) || decoderType.isSubtypeOf(type)
    }

    checkNotNull(decoder) { "Unable to find a decoder for $type" }

    return decoder as Decoder<T>
}