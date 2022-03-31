package dz.esi.sba.ezlive.compose.utilities.image.asyncimage.fetcher


import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.utils.path
import dz.esi.sba.ezlive.compose.utilities.image.core.DataSource
import dz.esi.sba.ezlive.compose.utilities.image.core.Resource
import dz.esi.sba.ezlive.compose.utilities.image.core.config.ResourceConfig
import dz.esi.sba.ezlive.compose.utilities.image.core.fetcher.Fetcher
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal object ResourcesFetcher : Fetcher<Url> {

    override val source: DataSource = DataSource.Disk

    override val Url.isSupported: Boolean
        get() = Thread.currentThread().contextClassLoader?.getResource(path) != null

    override fun fetch(
        data: Url,
        resourceConfig: ResourceConfig
    ): Flow<Resource<ByteReadChannel>> = flow {
        val bytes = Thread.currentThread().contextClassLoader
            ?.getResource(data.path)
            ?.readBytes()
            ?.let { ByteReadChannel(it) } ?: error("Unable to find resource $data")
        emit(Resource.Success(bytes))
    }

}