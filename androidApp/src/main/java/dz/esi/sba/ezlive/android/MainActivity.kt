package dz.esi.sba.ezlive.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dz.esi.sba.ezlive.Greeting
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import dz.esi.sba.ezlive.compose.theme.EzLiveTheme
import dz.esi.sba.ezlive.compose.ui.root.RootUi
import dz.esi.sba.ezlive.shared.navigation.root.RootComponent
import kotlinx.coroutines.MainScope

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = RootComponent(defaultComponentContext())

       setContent {
           EzLiveTheme {
               Surface(modifier = Modifier.fillMaxSize()) {
                   Column{
                           RootUi(root)
                   }
               }
           }
       }
    }
}
