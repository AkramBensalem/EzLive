package dz.esi.sba.ezlive.shared.presenters.authentication

import com.arkivanov.decompose.value.Value

interface AuthenticationScreenInterface {
    val models: Value<Model>

    fun onCloseClicked()

    data class Model(
        val isToolbarVisible: Boolean,
        val article: Article
    )

    data class Article(
        val title: String,
        val text: String
    )
}