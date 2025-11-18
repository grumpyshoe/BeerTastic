package com.grumpyshoe.beertastic.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.grumpyshoe.beertastic.presentation.features.details.navigation.DetailsNavKey
import com.grumpyshoe.beertastic.presentation.features.details.ui.DetailsRoot
import com.grumpyshoe.beertastic.presentation.features.home.navigation.HomeNavKey
import com.grumpyshoe.beertastic.presentation.features.home.ui.HomeRoot
import com.grumpyshoe.beertastic.presentation.features.splashscreen.navigation.SplashscreenNavKey
import com.grumpyshoe.beertastic.presentation.features.splashscreen.ui.SplashScreenRoot

@Composable
fun NavigationRoot(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(SplashscreenNavKey)

    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator(),
        ),
        entryProvider = { key ->
            when (key) {
                is SplashscreenNavKey -> {
                    NavEntry(
                        key = key,
                        content = {
                            SplashScreenRoot(
                                navigateForward = {
                                    backStack.add(HomeNavKey)
                                    backStack.removeFirstOrNull()
                                },
                            )
                        },
                    )
                }

                is HomeNavKey -> {
                    NavEntry(
                        key = key,
                        content = {
                            HomeRoot(
                                showDetails = {
                                    backStack.add(DetailsNavKey(it))
                                },
                            )
                        },
                    )
                }

                is DetailsNavKey -> {
                    NavEntry(
                        key = key,
                        content = {
                            DetailsRoot(
                                beerId = key.beerId,
                                navigateBack = {
                                    backStack.removeLastOrNull()
                                },
                            )
                        },
                    )
                }

                else -> throw RuntimeException("Invalid NavKey: $key")
            }
        },
    )
}
