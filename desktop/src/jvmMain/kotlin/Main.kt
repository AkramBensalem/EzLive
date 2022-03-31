import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import dz.esi.sba.ezlive.compose.theme.EzLiveTheme
import dz.esi.sba.ezlive.shared.navigation.root.RootComponent
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import dz.esi.sba.ezlive.compose.ui.root.RootUi
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.KamelImage
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.config.Default
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.config.LocalKamelConfig
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.config.resourcesFetcher
import dz.esi.sba.ezlive.compose.utilities.image.asyncimage.lazyPainterResource
import dz.esi.sba.ezlive.compose.utilities.image.core.config.Config
import dz.esi.sba.ezlive.compose.utilities.image.core.config.takeFrom
import kotlinx.coroutines.MainScope


@OptIn(ExperimentalComposeUiApi::class, com.arkivanov.decompose.ExperimentalDecomposeApi::class)
fun main() {

    val lifecycle = LifecycleRegistry()
    val root = RootComponent(DefaultComponentContext(lifecycle))

    application {
        val windowState = rememberWindowState()
        LifecycleController(lifecycle, windowState)

        Window(
            state = windowState,
            title = "EzLive",
            onCloseRequest = ::exitApplication
        ) {

            val kamelConfig = Config {
                takeFrom(Config.Default)
                resourcesFetcher()
            }


            EzLiveTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column(){
                        CompositionLocalProvider(LocalKamelConfig provides kamelConfig) {
                            RootUi(root)
                        }

                    }
                }
            }
        }
    }
}
