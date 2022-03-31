import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin(multiplatform)
    id(composePlugin) version Versions.desktop_compose_plugin
}

group = "dz.esi.sba.ezlive"
version = "1.0.0"

kotlin {
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val jvmMain by getting {
            kotlin.srcDirs("src/jvmMain/kotlin")

            dependencies {
                implementation(compose.desktop.currentOs)
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(compose.ui)
                api(compose.materialIconsExtended)

                implementation(Deps.napier)

                implementation(Deps.Coroutines.core)

                implementation(project(":shared"))
                implementation(project(":shared-ui"))

                with(Deps.Decompose){
                    implementation(core)
                    implementation(extensionsJetbrains)
                }

            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "EzLive"
            packageVersion = "1.0.0"
            macOS {
                bundleID = "dz.esi.sba.ezlive"
            }
            windows {
                menuGroup = "EzLive"
                upgradeUuid = "e50adebf-fbfa-4b9d-9288-0ec8beaf972d"
            }
        }
    }
}