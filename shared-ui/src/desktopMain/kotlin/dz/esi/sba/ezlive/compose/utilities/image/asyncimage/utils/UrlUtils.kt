package dz.esi.sba.ezlive.compose.utilities.image.asyncimage.utils

import io.ktor.http.*

internal val Url.path: String get() = encodedPath.removePrefix("/")