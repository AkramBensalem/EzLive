package ui.authentication

import androidx.compose.runtime.Composable
import dz.esi.sba.ezlive.shared.presenters.authentication.AuthenticationScreenInterface
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun AuthenticationUI(
    component: AuthenticationScreenInterface,
    ){
    Div() {
        Button(attrs = {
            style {
                onClick {
                    component.onCloseClicked()
                }
            }
        }) {
            Text("back")
        }
    }
}