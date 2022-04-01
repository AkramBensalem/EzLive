package ui.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*

@Composable
fun MaterialCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    attrs: AttrBuilderContext<*> = {},
    content: @Composable () -> Unit = {}
) {
    Div(attrs = attrs) {
        Label {
            Input(
                type = InputType.Checkbox,
                attrs = {
                    classes("filled-in")
                    checked(checked)
                    onChange { onCheckedChange(it.value) }
                }
            )

            Span {
                content()
            }
        }
    }
}