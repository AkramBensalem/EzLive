package ui.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Div

@Composable
fun Card(attrs: AttrBuilderContext<*> = {}, content: @Composable () -> Unit) {
    Div(
        attrs = {
            classes("card")
            attrs()
        }
    ) {
        content()
    }
}