package ui.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import dz.esi.sba.ezlive.shared.navigation.root.Root
import org.jetbrains.compose.web.dom.Div
import ui.authentication.AuthenticationUI
import ui.splash.SplashUI
import utils.extensions.subscribeAsState
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.bottom
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.right
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.width
import ui.components.layouts.Layout
import ui.components.layouts.MainContentLayout
import utils.animations.Crossfade

@Composable
fun RootUI(component: Root) {
        Layout{
            MainContentLayout {
                    SplashPane(component.splashRouterState)
                    AuthenticationPane(component.authenticationRouterState)
            }
        }
}





@Composable
private fun SplashPane(routerState: Value<RouterState<*, Root.SplashChild>>) {


    val state = routerState.subscribeAsState()

    Crossfade(
        target = state,
        attrs = {
            style {
                width(100.percent)
                height(100.percent)
                position(Position.Relative)
                left(0.px)
                top(0.px)
            }
        }
    ) {
        when (val child = it.value.activeChild.instance) {
            is Root.SplashChild.Splash -> SplashUI(child.component)
            is Root.SplashChild.None -> Div {}
        }
    }


}

@Composable
private fun AuthenticationPane(routerState: Value<RouterState<*, Root.AuthenticationChild>>) {
    val state = routerState.subscribeAsState()

    Crossfade(
        target = state,
        attrs = {
            style {
                width(100.percent)
                height(100.percent)
                position(Position.Relative)
                left(0.px)
                top(0.px)
            }
        }
    ) {
        when (val child = it.value.activeChild.instance) {
            is Root.AuthenticationChild.None -> Div {}
            is Root.AuthenticationChild.SignIn -> AuthenticationUI(child.component)
        }
    }

}
