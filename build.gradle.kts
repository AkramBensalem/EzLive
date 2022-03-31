buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(uri("https://plugins.gradle.org/m2/")) // For kotlinter-gradle
    }
    dependencies {
        classpath(Deps.kotlin_gradle_plugin)
        classpath(Deps.android_gradle_plugin)
        classpath(Deps.kotlin_serialization)
       // classpath(Deps.KotlinReflect)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven(url = "https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
        maven(url = "https://jitpack.io")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/kotlinx-coroutines/maven")
        maven(url = "https://kotlin.bintray.com/ktor")
    }
}


// https://youtrack.jetbrains.com/issue/KT-49109
afterEvaluate {
   rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin::class) {
        rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
            nodeVersion = "16.0.0"
            versions.webpackDevServer.version = "4.0.0"
            versions.webpackCli.version = "4.9.0"
        }
    }
}


