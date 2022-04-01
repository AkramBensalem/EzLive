package ui.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.*

@Composable
fun MaterialTextArea(
    id: String,
    label: String,
    text: String,
    onTextChanged: (String) -> Unit,
    attrs: AttrBuilderContext<*> = {}
) {
    Div(
        attrs = {
            classes("input-field", "col", "s12")
            attrs()
        }
    ) {
        TextArea(
            value = text,
            attrs = {
                id("text_area_add_todo")
                classes("materialize-textarea")
                onInput { onTextChanged(it.value) }
                style {
                    width(100.percent)
                    height(100.percent)
                }
            }
        )

        Label(forId = id) {
            Text(label)
        }
    }
}