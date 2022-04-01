package ui.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLUListElement

@Composable
fun NavBar(
    title: String,
    navigationIcon: NavBarIcon? = null
) {
    Nav {
        Div(attrs = { classes("nav-wrapper") }) {
            if (navigationIcon != null) {
                Ul(attrs = { classes("left") }) {
                    NavBarIcon(icon = navigationIcon)
                }
            }

            A(
                attrs = {
                    classes("brand-logo")
                    style {
                        property("padding-left", 16.px)
                    }
                }
            ) {
                Text(value = title)
            }
        }
    }
}

@Composable
private fun ElementScope<HTMLUListElement>.NavBarIcon(icon: NavBarIcon) {
    Li {
        A(
            attrs = {
                onClick { icon.onClick() }
            }
        ) {
            MaterialIcon(name = icon.name)
        }
    }
}

class NavBarIcon(
    val name: String,
    val onClick: () -> Unit
)