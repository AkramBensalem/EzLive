package dz.esi.sba.ezlive.shared.navigation.root

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import dz.esi.sba.ezlive.shared.presenters.authentication.AuthenticationScreenInterface
import dz.esi.sba.ezlive.shared.presenters.splash.SplashScreenInterface

interface Root {
    val splashRouterState: Value<RouterState<*, SplashChild>>
    val authenticationRouterState: Value<RouterState<*, AuthenticationChild>>


    sealed class SplashChild {
        class Splash(val component: SplashScreenInterface) : SplashChild()
        object None : SplashChild()
    }

    sealed class AuthenticationChild {
        object None : AuthenticationChild()
        data class SignIn(val component: AuthenticationScreenInterface) : AuthenticationChild()
    }
}