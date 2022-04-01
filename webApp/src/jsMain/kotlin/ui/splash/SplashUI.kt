package ui.splash

import androidx.compose.runtime.*
import dz.esi.sba.ezlive.shared.presenters.splash.SplashScreenInterface
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import ui.components.layouts.ContainerInSection
import ui.theme.colomun.WtCols
import ui.theme.row.WtRows
import utils.extensions.subscribeAsState

@Composable
fun SplashUI(
    component: SplashScreenInterface
) {
    //

    val model: SplashScreenInterface.Model by component.model.subscribeAsState()

    val scope = rememberCoroutineScope()


    LaunchedEffect(Unit) {
        scope.launch {
            while (true) {
                delay(500)
                component.onUpdateTitle()
            }
        }
    }

    ContainerInSection {
        Div({ }) {
                Button(attrs = {
                    style {
                        onClick {
                            component.onTimeFinished(1)
                        }
                    }
                }) {
                    Text("Click me  ${model.title}")
                }
        }
    }
}
