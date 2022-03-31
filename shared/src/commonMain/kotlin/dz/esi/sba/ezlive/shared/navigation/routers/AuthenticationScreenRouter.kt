package dz.esi.sba.ezlive.shared.navigation.routers

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.activeChild
import com.arkivanov.decompose.router.popWhile
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.badoo.reaktive.observable.Observable
import dz.esi.sba.ezlive.shared.navigation.root.Root
import dz.esi.sba.ezlive.shared.presenters.authentication.AuthenticationScreenComponent
import dz.esi.sba.ezlive.shared.presenters.authentication.AuthenticationScreenInterface

class AuthenticationScreenRouter(
    componentContext: ComponentContext,
    private val isToolbarVisible: Observable<Boolean>,
    private val onFinished: () -> Unit
)  {

    private val router =
        componentContext.router<Config, Root.AuthenticationChild>(
            initialConfiguration = Config.None,
            key = "AuthenticationRouter",
            childFactory = ::createChild
        )

    val state: Value<RouterState<Config, Root.AuthenticationChild>> = router.state

    private fun createChild(config: Config, componentContext: ComponentContext): Root.AuthenticationChild =
        when (config) {
            is Config.None -> Root.AuthenticationChild.None
            is Config.SignIn -> Root.AuthenticationChild.SignIn(articleDetails(componentContext = componentContext))
        }

    private fun articleDetails(componentContext: ComponentContext): AuthenticationScreenInterface =
        AuthenticationScreenComponent(
            componentContext = componentContext,
            isToolbarVisible = isToolbarVisible,
            onFinished = onFinished
        )

    fun showArticle(id: Long) {
        router.navigate { stack ->
            stack
                .dropLastWhile { it is Config.SignIn }
                .plus(Config.SignIn(articleId = id))
        }
    }

    fun closeArticle() {
        router.popWhile { it !is Config.None }
    }

    fun isShown(): Boolean =
        when (router.activeChild.configuration) {
            is Config.None -> false
            is Config.SignIn -> true
        }

    sealed class Config : Parcelable {
        @Parcelize
        object None : Config()

        @Parcelize
        data class SignIn(val articleId: Long) : Config()
    }



}