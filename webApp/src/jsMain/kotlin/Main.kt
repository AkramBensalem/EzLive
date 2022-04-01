import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import dz.esi.sba.ezlive.shared.navigation.root.RootComponent
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import ui.root.RootUI
import ui.theme.EzLiveStylesheet


fun main() {

     val lifecycle = LifecycleRegistry()
     val ctx = DefaultComponentContext(lifecycle = lifecycle)
     val root = RootComponent(ctx)

    lifecycle.resume()

    renderComposable(rootElementId = "root") {
        Style(EzLiveStylesheet)
        RootUI(root)
    }
}