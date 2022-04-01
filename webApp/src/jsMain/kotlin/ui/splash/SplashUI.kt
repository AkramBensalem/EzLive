package ui.splash

import androidx.compose.runtime.*
import dz.esi.sba.ezlive.shared.presenters.splash.SplashScreenInterface
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*
import ui.components.layouts.ContainerInSection
import ui.theme.image.WtImages.wtLogo
import ui.theme.image.WtImages.wtLogoDiv
import ui.theme.image.WtImages.wtTextDiv
import ui.theme.text.WtTexts.wtH1
import utils.extensions.subscribeAsState

@Composable
fun SplashUI(
    component: SplashScreenInterface
) {
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

    LaunchedEffect(Unit) {
        scope.launch {
            while (true) {
                delay(4000)
                component.onTimeFinished(1)
            }
        }
    }

     Div({
            classes(wtLogoDiv)
        }) {
            Img(
                src = "./drawable/logo.png",
                attrs = {
                    classes(wtLogo)
                }
            )

        }
        Div({
                classes(wtTextDiv)
            style { }
            }) {
            H1(
                attrs = {
                    classes(wtH1)
                }
            ) {
                Text(model.title)
            }
        }

}
