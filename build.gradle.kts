plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    id("com.google.devtools.ksp") version "1.9.21-1.0.16" apply false
    id("de.jensklingenberg.ktorfit") version "1.11.1" apply false
}