package ui.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import dz.esi.sba.ezlive.shared.navigation.root.Root
import org.jetbrains.compose.web.dom.Div
import ui.authentication.AuthenticationUI
import ui.splash.SplashUI


@Composable
fun RootUI(component: Root) {
    Div {
        SplashPane(component.splashRouterState)
        AuthenticationPane(component.authenticationRouterState)
    }
}

@Composable
private fun SplashPane(routerState: Value<RouterState<*, Root.SplashChild>>) {
        when (val child = routerState.value.activeChild.instance) {
            is Root.SplashChild.Splash -> SplashUI(child.component)
            is Root.SplashChild.None -> Div {}
        }
}

@Composable
private fun AuthenticationPane(routerState: Value<RouterState<*, Root.AuthenticationChild>>) {
        when (val child = routerState.value.activeChild.instance) {
            is Root.AuthenticationChild.None -> Div {}
            is Root.AuthenticationChild.SignIn -> AuthenticationUI()
        }
}
