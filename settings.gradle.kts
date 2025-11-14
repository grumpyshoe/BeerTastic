pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "BeerTastic"
include(":app")
include(":data:repository")
include(":data:source:network")
include(":data:source:preferences")
include(":domain:beer")
include(":presentation:features:splashscreen")
include(":presentation:common:resources")
include(":presentation:features:home")
include(":presentation:features:details")
