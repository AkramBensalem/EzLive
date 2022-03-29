import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dz.esi.sba.ezlive.Greeting
import dz.esi.sba.ezlive.compose.theme.EzLiveTheme


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        EzLiveTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                Text("Hello ${Greeting().greeting()}")
            }
        }
    }
}
