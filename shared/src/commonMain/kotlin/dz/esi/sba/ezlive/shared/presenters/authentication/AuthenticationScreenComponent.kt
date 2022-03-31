package dz.esi.sba.ezlive.shared.presenters.authentication

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.reduce
import com.badoo.reaktive.disposable.scope.DisposableScope
import com.badoo.reaktive.observable.Observable
import dz.esi.sba.ezlive.shared.utils.disposableScope

class AuthenticationScreenComponent(
    componentContext: ComponentContext,
    isToolbarVisible: Observable<Boolean>,
    private val onFinished: () -> Unit
): AuthenticationScreenInterface, ComponentContext by componentContext, DisposableScope by componentContext.disposableScope() {
    private val _models =
        MutableValue(
            AuthenticationScreenInterface.Model(
                isToolbarVisible = false,
                article = AuthenticationScreenInterface.Article(
                    title = "title",
                    text = "yes"
                )
            )
        )

    override val models: Value<AuthenticationScreenInterface.Model> = _models

    init {
        isToolbarVisible.subscribeScoped { isVisible ->
            _models.reduce { it.copy(isToolbarVisible = isVisible) }
        }
    }



    override fun onCloseClicked() {
        onFinished()
    }
}