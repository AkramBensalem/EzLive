package dz.esi.sba.ezlive.compose.ui.splash


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import dz.esi.sba.ezlive.compose.RemoteImage
import dz.esi.sba.ezlive.compose.theme.blueSurface
import dz.esi.sba.ezlive.shared.presenters.splash.SplashScreenInterface
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashUi(
    component: SplashScreenInterface,
    modifier: Modifier = Modifier
) {
    val model: SplashScreenInterface.Model by component.model.subscribeAsState()

    val scope = rememberCoroutineScope()


    LaunchedEffect(Unit) {
        scope.launch {
            while (true){
                delay(500)
                component.onUpdateTitle()
            }
        }
    }

    LaunchedEffect(Unit){
        scope.launch {
            delay(4000)
            component.onTimeFinished(1)
        }
    }

    Box(
        modifier = modifier.background(blueSurface, shape = MaterialTheme.shapes.large),
        contentAlignment = Alignment.Center,
        ) {
        PulseEffect {
            RemoteImage(
                url = model.image,
                contentDescription = "${model.title} logo",
                modifier = Modifier
                    .fillMaxSize(0.33f)
                    .aspectRatio(1f)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

        }

        Text(
            text = model.title,
            modifier = Modifier.align(Alignment.BottomCenter).padding(64.dp),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onSurface
        )
    }

}


