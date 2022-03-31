plugins {
    kotlin(multiplatform)
    id(composePlugin) version Versions.desktop_compose_plugin
}


version = "1.0"


repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}



kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation(project(":shared"))
                implementation(Deps.ArkIvanov.Decompose.decompose)
                implementation(Deps.ArkIvanov.Essenty.lifecycle)

            }
        }
    }

}



// On Apple Silicon we need Node.js 16.0.0
// https://youtrack.jetbrains.com/issue/KT-49109
rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin::class) {
    rootProject.the(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension::class).nodeVersion = "16.0.0"
}
