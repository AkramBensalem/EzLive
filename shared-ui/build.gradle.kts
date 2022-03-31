import org.jetbrains.compose.compose

plugins {
    kotlin(multiplatform)
    id(androidLib)
    id(composePlugin) version Versions.desktop_compose_plugin
}

android {
    compileSdk =  Versions.compile_sdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
dependencies {
    implementation("com.android.volley:volley:1.2.0")
}

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared"))


                implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")

                implementation(compose.foundation)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.materialIconsExtended)
                implementation(compose.ui)

                with(Deps.Decompose){
                    api(core)
                    api(extensionsJetbrains)
                }
                with(Deps.Ktor){
                    api(core)
                    api(cio)
                    api(logging)
                }

            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                implementation("io.coil-kt:coil-compose:2.0.0-rc02")
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation("com.squareup.okhttp3:okhttp:4.9.3")
                implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
            }
        }
    }
}