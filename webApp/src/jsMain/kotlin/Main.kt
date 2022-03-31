import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import dz.esi.sba.ezlive.Greeting
import dz.esi.sba.ezlive.shared.navigation.root.RootComponent
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import ui.root.RootUI


fun main() {

     val lifecycle = LifecycleRegistry()
     val ctx = DefaultComponentContext(lifecycle = lifecycle)
     val root = RootComponent(ctx)

    renderComposable(rootElementId = "root") {
      //  Style(TextStyles)



        RootUI(root)

        Div(attrs = { style { padding(16.px) } }) {
            H2 {
                Text("Hello ${Greeting().greeting()}")
            }
        }
    }
}