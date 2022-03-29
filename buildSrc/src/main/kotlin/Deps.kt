object Deps {
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_gradle_plugin}"
    const val kotlin_serialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin_gradle_plugin}"
    const val junit = "junit:junit:${Versions.junit}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val napier = "io.github.aakira:napier:${Versions.napier}"



object Compose {
    const val  ui ="androidx.compose.ui:ui:${Versions.compose_version}"
    const val  uiUtil = "androidx.compose.ui:ui-util:${Versions.compose_version}"
    const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose_version}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.compose_version}"
    const val material = "androidx.compose.material:material:${Versions.compose_version}"
    const val material_icons = "androidx.compose.material:material-icons-extended:${Versions.compose_version}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose_version}"
    const val compiler = "androidx.compose.compiler:compiler:${Versions.compose_version}"
    const val runtime_livedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose_version}"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose_version}"
    const val activity ="androidx.activity:activity-compose:${Versions.activity_compose}"

}
    object JetBrain {
      const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDateTime}"
      const val uiDesktop = "org.jetbrains.compose.ui:ui-desktop:${Versions.desktop_compose_plugin}"
      const val uiUtil = "org.jetbrains.compose.ui:ui-util:${Versions.desktop_compose_plugin}"

        const val serializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serializationJson}"

    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object Decompose {
        const val core = "com.arkivanov.decompose:decompose:${Versions.decompose}"
        const val extensionsJetpack = "com.arkivanov.decompose:extensions-compose-jetpack:${Versions.decompose}"
        const val extensionsJetbrains = "com.arkivanov.decompose:extensions-android:${Versions.decompose}"
        const val extensionsAndroid= "com.arkivanov.decompose:extensions-android:${Versions.decompose}"
    }


    object Reactive{
        const val annotations = "com.badoo.reaktive:reaktive-annotations:${Versions.reactive}"
        const val coroutinesInterop = "com.badoo.reaktive:coroutines-interop:${Versions.reactive}"
        const val reaktive = "com.badoo.reaktive:reaktive:${Versions.reactive}"
    }

    object Kermit{
        const val kermit = "co.touchlab:kermit:${Versions.kermit}"
    }



}


