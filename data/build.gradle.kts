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
            baseName = "Data"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.database)
            implementation(projects.core.network)
            implementation(projects.domain)
            implementation(projects.core.di)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}