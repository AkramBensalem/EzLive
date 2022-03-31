package dz.esi.sba.ezlive.compose.utilities.image.core.mapper


import dz.esi.sba.ezlive.compose.utilities.image.core.utils.URI
import dz.esi.sba.ezlive.compose.utilities.image.core.utils.URL
import io.ktor.http.*

internal val StringMapper: Mapper<String, Url> = Mapper { Url(it) }


internal  val URLMapper: Mapper<URL, Url> = Mapper { URIMapper.map(it.toURI()) }

internal  val URIMapper: Mapper<URI, Url> = Mapper { Url(it) }