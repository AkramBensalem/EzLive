package dz.esi.sba.ezlive.shared.navigation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value
import com.badoo.reaktive.subject.behavior.BehaviorSubject
import dz.esi.sba.ezlive.shared.navigation.routers.AuthenticationScreenRouter
import dz.esi.sba.ezlive.shared.navigation.routers.SplashScreenRouter
import kotlinx.coroutines.CoroutineScope


class RootComponent(
    componentContext: ComponentContext,
    ) : Root, ComponentContext by componentContext {


    private val selectedArticleIdSubject = BehaviorSubject<Long?>(null)
    private val isDetailsToolbarVisible = BehaviorSubject(true)

    private val splashRouter =
        SplashScreenRouter(
            componentContext = this,
            screenState = selectedArticleIdSubject,
            onSplashScreenFinished = ::onArticleSelected
        )


    override val splashRouterState: Value<RouterState<*, Root.SplashChild>>
        get() = splashRouter.state


    private fun onArticleSelected(id: Long) {
        authenticationRouter.showArticle(id = id)
        splashRouter.moveToBackStack()
    }


    private val authenticationRouter =
        AuthenticationScreenRouter(
            componentContext = this,
            isToolbarVisible = isDetailsToolbarVisible,
            onFinished = ::closeDetailsAndShowList
        )


    override val authenticationRouterState: Value<RouterState<*, Root.AuthenticationChild>>
        get() = authenticationRouter.state


    private fun closeDetailsAndShowList() {
        splashRouter.show()
        authenticationRouter.closeArticle()
    }
}