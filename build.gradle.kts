import com.diffplug.spotless.extra.wtp.EclipseWtpFormatterStep.XML

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.diffplugKotlin)
}

spotless {
    kotlin {
        //ratchetFrom("origin/main")
        target("**/*.kt")
        targetExclude(
            "spotless/**/*.kt",
            "**/build/**/*.kt",
            "**/generated/**/*.kt",
            ".gradle/**/*.kt"
        )
        ktlint("1.7.1").editorConfigOverride(
            mapOf(
                "ktlint_function_naming_ignore_when_annotated_with" to "Composable",
            )
        )
        trimTrailingWhitespace()
        endWithNewline()
    }
    java {
        target("**/*.java")
    }
}

allprojects {

    extra.apply {
        set("compileSdkVersion", 34)
        set("minSdkVersion", 26)
        set("targetSdkVersion", 34)
    }
}
