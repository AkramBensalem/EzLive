package ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import dz.esi.sba.ezlive.shared.presenters.splash.SplashScreenInterface
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun SplashUI(
    component: SplashScreenInterface
){
    Div(
        attrs = {
            onClick {
                component.onTimeFinished(1)
            }
        }
    ) {
        Button(attrs = {
            style {
                onClick {
                    component.onTimeFinished(1)
                }
            }
        }) {
            Text("Click me")
        }
    }
}