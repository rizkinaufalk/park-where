plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin{

    jvm()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "CoreNetwork"
            isStatic = true
        }
    }

    sourceSets {

        commonMain.dependencies {
            implementation(projects.core.di)

            implementation(libs.ktor.content)
            implementation(libs.ktor.auth)
            implementation(libs.ktor.serialization.json)
            implementation(libs.ktor.logging)
            implementation(libs.ktor.core)

            implementation(libs.logging.napier)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}