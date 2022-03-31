package dz.esi.sba.ezlive.compose.utilities.image.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.io.File
import java.net.URI
import java.net.URL

internal  val Dispatchers.IO: CoroutineDispatcher get() = IO

internal  typealias File = File

internal  typealias URL = URL

internal  typealias URI = URI