package dz.esi.sba.ezlive.compose.utilities.image.core.fetcher


import dz.esi.sba.ezlive.compose.utilities.image.core.DataSource
import dz.esi.sba.ezlive.compose.utilities.image.core.Resource
import dz.esi.sba.ezlive.compose.utilities.image.core.config.ResourceConfig
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.File

/**
 * Fetcher that fetchers [ByteReadChannel] from a file.
 */
internal  object FileFetcher : Fetcher<File> {

    override val source: DataSource = DataSource.Disk

    override val File.isSupported: Boolean
        get() = exists() && isFile

    override fun fetch(
        data: File,
        resourceConfig: ResourceConfig
    ): Flow<Resource<ByteReadChannel>> = flow {
        val bytes = data.readChannel(coroutineContext = resourceConfig.coroutineContext)
        emit(Resource.Success(bytes))
    }

}