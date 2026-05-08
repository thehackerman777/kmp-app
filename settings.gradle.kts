pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "kmp-app"
include(":shared")
include(":androidApp")
include(":desktopApp")
include(":backend")

// For androidApp module which uses kotlin("android") without version
// (version resolved from catalog)
