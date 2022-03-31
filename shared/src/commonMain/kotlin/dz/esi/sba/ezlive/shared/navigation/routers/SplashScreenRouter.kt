package dz.esi.sba.ezlive.shared.navigation.routers


import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.activeChild
import com.arkivanov.decompose.router.pop
import com.arkivanov.decompose.router.push
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.badoo.reaktive.observable.Observable
import dz.esi.sba.ezlive.shared.navigation.root.Root
import dz.esi.sba.ezlive.shared.presenters.splash.SplashScreenComponent
import dz.esi.sba.ezlive.shared.presenters.splash.SplashScreenInterface
import kotlinx.coroutines.CoroutineScope


internal class SplashScreenRouter(
    componentContext: ComponentContext,
    private val screenState: Observable<Long?>,
    private val onSplashScreenFinished: (id: Long) -> Unit
) {


    private val router = componentContext.router<Config, Root.SplashChild>(
            initialConfiguration = Config.Splash,
            key = "SplashRouter",
            childFactory = ::createChild
        )

    val state: Value<RouterState<Config, Root.SplashChild>> = router.state



    private fun createChild(config: Config, componentContext: ComponentContext): Root.SplashChild =
        when (config) {
            is Config.Splash -> Root.SplashChild.Splash(articleList(componentContext))
            is Config.None -> Root.SplashChild.None
        }

    private fun articleList(componentContext: ComponentContext): SplashScreenInterface =
        SplashScreenComponent(
            componentContext = componentContext,
            splashScreenState = screenState,
            onFinished = onSplashScreenFinished,
        )



    fun moveToBackStack() {
        if (router.activeChild.configuration !is Config.None) {
            router.push(Config.None)
        }
    }

    fun show() {
        if (router.activeChild.configuration !is Config.Splash) {
            router.pop()
        }
    }



    sealed class Config : Parcelable {
        @Parcelize
        object Splash : Config()

        @Parcelize
        object None : Config()
    }
}