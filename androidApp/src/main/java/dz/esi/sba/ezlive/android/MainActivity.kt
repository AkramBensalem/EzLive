package dz.esi.sba.ezlive.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dz.esi.sba.ezlive.Greeting
import androidx.activity.compose.setContent
import androidx.compose.material.Text

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent {
           Text(text = "Hello, ${greet()}")
       }
    }
}
