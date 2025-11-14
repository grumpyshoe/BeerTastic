plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.diffplugKotlin) apply false
}

android {
    namespace = "com.grumpyshoe.beertastic.data.repository"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

}

dependencies {

    // Modules
    implementation(project(":data:source:network"))
    implementation(project(":data:source:preferences"))
    implementation(project(":domain:beer"))

    // Dependency Injection
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    // Async
    implementation(libs.kotlinx.coroutines.core)

    // Tests
    testImplementation(libs.junit)
}
