import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    
    alias(libs.plugins.jetbrainsCompose)
    id("com.google.devtools.ksp")
    id("de.jensklingenberg.ktorfit")
}

kotlin {
    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting
        
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation("com.slack.circuit:circuit-foundation:0.18.1")
            implementation("com.slack.circuit:circuit-runtime:0.18.1")
            implementation("com.slack.circuit:circuit-runtime-presenter:0.18.1")
            implementation("com.slack.circuit:circuit-runtime-ui:0.18.1")
            implementation("com.slack.circuit:circuit-backstack:0.18.1")
            api("com.slack.circuit:circuit-codegen-annotations:0.18.1")
            implementation("de.jensklingenberg.ktorfit:ktorfit-lib:1.11.1")
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}


compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "dev.tsnanh.geminichat"
            packageVersion = "1.0.0"
        }
    }
}

dependencies {
    ksp("com.slack.circuit:circuit-codegen:0.18.1")
    ksp("de.jensklingenberg.ktorfit:ktorfit-ksp:1.11.1")
}
