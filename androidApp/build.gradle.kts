plugins {
    id(androidApp)
    kotlin(androidPlugin)
}
android {
    compileSdk = Versions.compile_sdk
    defaultConfig {
        applicationId = "dz.esi.sba.ezlive.android"
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8" }
    buildFeatures { compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_compiler_version
    }
}




dependencies {
    implementation(project(":shared"))

    with(Deps){
        implementation(napier)
        implementation(material)
    }

    with(Deps.Compose){
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
    with(Deps.Decompose){
        implementation(core)
        implementation(extensionsJetpack)
        implementation(extensionsAndroid)
    }
}