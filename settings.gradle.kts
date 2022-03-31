pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "EzLive"


include(":androidApp")
include(":desktop")
include(":shared")
include(":shared-ui")
include(":webApp")


