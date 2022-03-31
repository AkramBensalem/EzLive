package dz.esi.sba.ezlive.compose.utilities.image

import io.ktor.client.*
import io.ktor.client.engine.cio.*

val client = HttpClient(CIO){
    engine {
        // this: CIOEngineConfig
        maxConnectionsCount = 1000
        endpoint {
            // this: EndpointConfig
            maxConnectionsPerRoute = 100
            pipelineMaxSize = 20
            keepAliveTime = 5000
            connectTimeout = 5000
            connectAttempts = 5
        }
    }
}