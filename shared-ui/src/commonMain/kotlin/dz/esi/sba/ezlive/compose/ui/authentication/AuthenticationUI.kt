package dz.esi.sba.ezlive.compose.ui.authentication

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dz.esi.sba.ezlive.shared.presenters.authentication.AuthenticationScreenComponent
import dz.esi.sba.ezlive.shared.presenters.authentication.AuthenticationScreenInterface

@Composable
fun AuthenticationUI(
    component: AuthenticationScreenInterface,
    modifier : Modifier = Modifier,
 ){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text("Content")
        Button(onClick = {component.onCloseClicked()}){
            Text("Back")
        }
    }
}