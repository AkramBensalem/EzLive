package dz.esi.sba.ezlive.compose.ui.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import dz.esi.sba.ezlive.compose.ui.authentication.AuthenticationUI
import dz.esi.sba.ezlive.compose.ui.splash.SplashUi
import dz.esi.sba.ezlive.compose.utils.CustomScaleChildAnimation
import dz.esi.sba.ezlive.shared.navigation.root.Root


@Composable
fun RootUi(component: Root) {
    BoxWithConstraints {
        SplashPane(component.splashRouterState)
        AuthenticationPane(component.authenticationRouterState)
    }
}

@Composable
private fun SplashPane(routerState: Value<RouterState<*, Root.SplashChild>>) {
    Children(
        routerState = routerState,
        animation = CustomScaleChildAnimation()
    ) {
        when (val child = it.instance) {
            is Root.SplashChild.Splash -> SplashUi(
                component = child.component,
                modifier = Modifier.fillMaxSize()
            )
            is Root.SplashChild.None -> Box {}
        }
    }
}

@Composable
private fun AuthenticationPane(routerState: Value<RouterState<*, Root.AuthenticationChild>>) {
    Children(
        routerState = routerState,
        animation = CustomScaleChildAnimation()
    ) {
        when (val child = it.instance) {
            is Root.AuthenticationChild.None -> Box {}
            is Root.AuthenticationChild.SignIn -> AuthenticationUI(
                child.component,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

