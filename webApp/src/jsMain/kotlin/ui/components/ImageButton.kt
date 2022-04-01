package ui.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*


@Composable
fun MaterialIcon(name: String) {
    I(attrs = { classes("material-icons") }) { Text(value = name) }
}

@Composable
fun ImageButton(
    onClick: () -> Unit,
    iconName: String,
    attrs: AttrBuilderContext<*> = {}
) {
    A(
        attrs = {
            classes("waves-effect", "waves-teal", "btn-flat")
            style {
                width(48.px)
                height(48.px)
                display(DisplayStyle.Flex)
                alignItems(AlignItems.Center)
                justifyContent(JustifyContent.Center)
            }
            this.onClick { onClick() }
            attrs()
        }
    ) {
        MaterialIcon(name = iconName)
    }
}