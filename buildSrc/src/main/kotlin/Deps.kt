object Deps {
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_gradle_plugin}"
    const val kotlin_serialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin_gradle_plugin}"
    const val KotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin_gradle_plugin}"


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
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object Decompose {
        const val core = "com.arkivanov.decompose:decompose:${Versions.decompose}"
        const val extensionsJetpack =   "com.arkivanov.decompose:extensions-compose-jetpack:${Versions.decompose}"
        const val extensionsJetbrains = "com.arkivanov.decompose:extensions-compose-jetbrains:${Versions.decompose}"
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


    object Ktor {
        const val core = "io.ktor:ktor-client-core:${Versions.Ktor}"
        const val logging = "io.ktor:ktor-client-logging:${Versions.Ktor}"
        const val android = "io.ktor:ktor-client-android:${Versions.Ktor}"
        const val cio = "io.ktor:ktor-client-cio:${Versions.Ktor}"
    }



    object ArkIvanov {
        object MVIKotlin {
            private const val VERSION = "3.0.0-beta01"
            const val rx = "com.arkivanov.mvikotlin:rx:$VERSION"
            const val mvikotlin = "com.arkivanov.mvikotlin:mvikotlin:$VERSION"
            const val mvikotlinMain = "com.arkivanov.mvikotlin:mvikotlin-main:$VERSION"
            const val mvikotlinLogging = "com.arkivanov.mvikotlin:mvikotlin-logging:$VERSION"
            const val mvikotlinTimeTravel = "com.arkivanov.mvikotlin:mvikotlin-timetravel:$VERSION"
            const val mvikotlinExtensionsReaktive = "com.arkivanov.mvikotlin:mvikotlin-extensions-reaktive:$VERSION"
        }

        object Decompose {
            private const val VERSION = "0.5.2"
            const val decompose = "com.arkivanov.decompose:decompose:$VERSION"
            const val extensionsCompose = "com.arkivanov.decompose:extensions-compose-jetbrains:$VERSION"
        }

        object Essenty {
            private const val VERSION = "0.2.2"
            const val lifecycle = "com.arkivanov.essenty:lifecycle:$VERSION"
        }
    }

    object Badoo {
        object Reaktive {
            private const val VERSION = "1.1.22"
            const val reaktive = "com.badoo.reaktive:reaktive:$VERSION"
            const val reaktiveTesting = "com.badoo.reaktive:reaktive-testing:$VERSION"
            const val utils = "com.badoo.reaktive:utils:$VERSION"
            const val coroutinesInterop = "com.badoo.reaktive:coroutines-interop:$VERSION"
        }
    }



}


