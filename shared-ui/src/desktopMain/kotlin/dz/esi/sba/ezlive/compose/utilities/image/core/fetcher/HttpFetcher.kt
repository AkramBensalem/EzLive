package dz.esi.sba.ezlive.compose.utilities.image.core.fetcher

import dz.esi.sba.ezlive.compose.utilities.image.core.DataSource
import dz.esi.sba.ezlive.compose.utilities.image.core.Resource
import dz.esi.sba.ezlive.compose.utilities.image.core.config.ResourceConfig
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

/**
 * Fetcher that fetches [ByteReadChannel] from network using [Url].
 */
internal class HttpFetcher(private val client: HttpClient) : Fetcher<Url> {

    override val source: DataSource = DataSource.Network

    override val Url.isSupported: Boolean
        get() = protocol.name == "https" || protocol.name == "http"

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun fetch(
        data: Url,
        resourceConfig: ResourceConfig
    ): Flow<Resource<ByteReadChannel>> = channelFlow {
        val response = client.request<HttpResponse> {
            onDownload { bytesSentTotal, contentLength ->
                val progress = (bytesSentTotal.toFloat() / contentLength).coerceAtMost(1.0F)
                send(Resource.Loading(progress))
            }
            takeFrom(resourceConfig.requestData)
            url(data)
        }
        val bytes = response.receive<ByteReadChannel>()
        send(Resource.Success(bytes))
    }

}