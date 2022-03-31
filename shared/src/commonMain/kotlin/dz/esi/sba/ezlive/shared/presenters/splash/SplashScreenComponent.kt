package dz.esi.sba.ezlive.shared.presenters.splash

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.reduce
import com.badoo.reaktive.disposable.scope.DisposableScope
import com.badoo.reaktive.disposable.scope.disposableScope
import com.badoo.reaktive.observable.Observable
import dz.esi.sba.ezlive.shared.utils.disposableScope
import kotlinx.coroutines.*

internal class SplashScreenComponent(
    componentContext: ComponentContext,
    splashScreenState: Observable<Long?>,
    private val onFinished : (state: Long) -> Unit
) : SplashScreenInterface, ComponentContext by componentContext, DisposableScope by componentContext.disposableScope() {

    private val _state =
        MutableValue(
            SplashScreenInterface.Model(
                title = "EzLive",
                image = "logo.png",
                state = "1"
            )
        )


    override val model: Value<SplashScreenInterface.Model>
        get() = _state

    override fun onTimeFinished(state: Long) {
        onFinished(state)
    }

    override fun onUpdateTitle() {
        _state.reduce {
            when {
                it.title.contains("...") -> it.copy(title = it.title.removeSuffix("...") + "   ")
                it.title.contains(".. ") -> it.copy(title = it.title.removeSuffix(".. ") + "...")
                it.title.contains(".  ") -> it.copy(title = it.title.removeSuffix(".  ") + ".. ")
                else ->it.copy(title = it.title.removeSuffix("   ") + ".  ")
            }
        }
    }
}