import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin(multiplatform)
    kotlin(cocoapods)
    id(androidLib)
    id(parcelize)
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()


    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    js(IR) {
        useCommonJs()
        browser()
    }





    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
         //   export(project(":shared"))
           export(Deps.ArkIvanov.Decompose.decompose)
            export(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
            export(Deps.ArkIvanov.Essenty.lifecycle)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                with(Deps.JetBrain) {
                    implementation(datetime)
                    implementation(serializationJson)
                    implementation(coroutinesCore)
                }

                with(Deps.Coroutines) {
                    implementation(core)
                }

                implementation(Deps.napier)

                implementation(Deps.Kermit.kermit)

                with(Deps.Reactive) {
                    implementation(annotations)
                    implementation(coroutinesInterop)
                    implementation(reaktive)
                }

                implementation(Deps.Decompose.core)


                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlin)
                implementation(Deps.ArkIvanov.MVIKotlin.mvikotlinExtensionsReaktive)
                implementation(Deps.ArkIvanov.MVIKotlin.rx)


            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                with(Deps.Decompose) {
                    implementation(core)
                    implementation(extensionsJetpack)
                    implementation(extensionsAndroid)
                }
                with(Deps.Compose) {
                    implementation(compiler)
                    implementation(runtime)
                    implementation(runtime_livedata)
                    implementation(ui)
                    implementation(tooling)
                    implementation(foundation)
                    implementation(foundationLayout)
                    implementation(material)
                    implementation(material_icons)
                    implementation(activity)
                }
            }

        }


        val jsMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
           iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                api(Deps.ArkIvanov.Decompose.decompose)
                api(Deps.ArkIvanov.MVIKotlin.mvikotlinMain)
                api(Deps.ArkIvanov.Essenty.lifecycle)
            }


        }
        val iosX64Test by getting
        val iosArm64Test by getting
       val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
           iosSimulatorArm64Test.dependsOn(this)
        }
    }
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

android {
    compileSdk = Versions.compile_sdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
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