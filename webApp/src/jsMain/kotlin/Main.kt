import dz.esi.sba.ezlive.Greeting
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable


fun main() {
    renderComposable(rootElementId = "root") {
      //  Style(TextStyles)
        Div(attrs = { style { padding(16.px) } }) {
            H2 {
                Text("Hello ${Greeting().greeting()}")
            }
        }
    }
}