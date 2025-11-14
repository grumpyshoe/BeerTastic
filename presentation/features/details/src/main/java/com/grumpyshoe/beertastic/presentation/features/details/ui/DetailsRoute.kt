package com.grumpyshoe.beertastic.presentation.features.details.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppTheme
import com.grumpyshoe.beertastic.presentation.features.details.ui.components.Details
import com.grumpyshoe.beertastic.presentation.features.details.ui.components.Error
import com.grumpyshoe.beertastic.presentation.features.details.ui.components.Loading
import com.grumpyshoe.beertastic.presentation.features.details.ui.uimodel.BeerDetailUIItem
import com.grumpyshoe.beertastic.presentation.features.details.ui.uimodel.BeerDetailsDataState
import com.grumpyshoe.beertastic.presentation.features.details.viewmodel.DetailsViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun DetailsRoot(
    beerId: Int,
    viewModel: DetailsViewModel = koinViewModel(parameters = { parametersOf(beerId) }),
    navigateBack: () -> Unit,
) {
    val beerDetailsDataState by viewModel.beerDetailsDataState.collectAsState()

    DetailsScreen(
        state = beerDetailsDataState,
        toggleFavorite = viewModel::toggleFavorite,
        navigateBack = navigateBack,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailsScreen(
    state: BeerDetailsDataState,
    toggleFavorite: () -> Unit,
    navigateBack: () -> Unit,
) {
    Scaffold(

        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                },
                title = {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "More about...",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                },
                actions = {
                    val icon = if (state is BeerDetailsDataState.DataLoaded && state.isFavorite) {
                        Icons.Filled.Favorite
                    } else {
                        Icons.Outlined.FavoriteBorder
                    }
                    IconButton(onClick = toggleFavorite) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                },
            )
        },
    ) { paddingValues ->

        Box(modifier = Modifier.padding(paddingValues)) {
            when (state) {
                BeerDetailsDataState.Loading -> Loading()
                is BeerDetailsDataState.Error -> Error()
                is BeerDetailsDataState.DataLoaded -> Details(
                    beerDetails = state.data,
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun BerDetailsScreenLoadingPreview() {
    AppTheme {
        DetailsScreen(
            state = BeerDetailsDataState.Loading,
            navigateBack = {},
            toggleFavorite = {},
        )
    }
}

@PreviewLightDark
@Composable
private fun BerDetailsScreenErrorPreview() {
    AppTheme {
        DetailsScreen(
            state = BeerDetailsDataState.Error(),
            navigateBack = {},
            toggleFavorite = {},
        )
    }
}

@PreviewLightDark
@Composable
private fun BerDetailsScreenBeerOverviewPreview() {
    AppTheme {
        DetailsScreen(
            state = BeerDetailsDataState.DataLoaded(
                isFavorite = false,
                BeerDetailUIItem(
                    id = 0,
                    name = "item_0",
                    tagline = "tag1, tag2",
                    description = "description 123",
                    imageUrl = null,
                    firstBrewed = "2012-04-12",
                    abv = "6.0",
                    ibu = "60.0",
                    targetFG = "1010.0",
                    targetOG = "1056.0",
                    ebc = "17.0",
                    srm = "8.5",
                    ph = "4.4",
                    attenuationLevel = "82.14",
                    volume = "20 liters",
                    boilVolume = "25 liters",
                    method = listOf(
                        "Mash - 65°C - 75min.",
                        "Fermentation - 19°C - ",
                    ),
                    ingredients = listOf(
                        "malt - Extra Pale - 5.3Kg",
                        "hops - Ahtanum - 17.5g",
                        "hops - Chinook - 15g - start - (bitter)",
                    ),
                    foodPairing = listOf(
                        "Spicy carne asada with a pico de gallo sauce",
                        "Shredded chicken tacos with a mango chilli lime salsa",
                        "Cheesecake with a passion fruit swirl sauce",
                    ),
                    brewersTips = "brewer tips",
                    contributedBy = "Sam Mason <samjbmason>",
                ),
            ),
            navigateBack = {},
            toggleFavorite = {},
        )
    }
}
