package dz.esi.sba.ezlive.shared.presenters.splash

import com.arkivanov.decompose.value.Value

interface SplashScreenInterface {

    val model: Value<Model>

    fun onTimeFinished(state: Long)
    fun onUpdateTitle()

     data class Model(
        val title: String,
        val image: String,
        val state : String
    )

}