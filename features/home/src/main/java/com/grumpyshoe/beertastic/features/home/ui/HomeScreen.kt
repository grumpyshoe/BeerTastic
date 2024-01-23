package com.grumpyshoe.beertastic.features.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.grumpyshoe.beertastic.common.resources.R
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppNameTheme
import com.grumpyshoe.beertastic.features.home.ui.uistates.ErrorState
import com.grumpyshoe.beertastic.features.home.ui.uistates.LoadingState
import com.grumpyshoe.beertastic.features.home.ui.uimodel.BeerDataState
import com.grumpyshoe.beertastic.features.home.ui.uimodel.BeerUIItem
import com.grumpyshoe.beertastic.features.home.ui.uistates.BeerListState
import com.grumpyshoe.beertastic.features.home.viewmodel.HomeViewModel
import com.grumpyshoe.common.ui.DefaultLightDarkPreview

@Composable
internal fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    showDetails: (Int) -> Unit,
) {
    val viewState by viewModel.viewState.collectAsState()

    val beerList by viewModel.beerList.collectAsState(null)
    val favorites by viewModel.favorites.collectAsState(null)
    val randomBeer by viewModel.randomBeer.collectAsState(null)

    HomeScreen(
        beerDataState = viewState,
        favorites = favorites,
        beerList = beerList ?: emptyList(),
        loadMoreData = viewModel::loadMoreData,
        showDetails = showDetails,
        randomBeer = randomBeer,
        showRandomBeer = viewModel::showRandomBeer
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen(
    beerDataState: BeerDataState,
    favorites: List<BeerUIItem>?,
    beerList: List<BeerUIItem>,
    loadMoreData: () -> Unit,
    showDetails: (Int) -> Unit,
    randomBeer: BeerUIItem?,
    showRandomBeer: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.home_title))
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            )
        }
    ) { paddingValues ->

        Box(modifier = Modifier.padding(paddingValues)) {
            when (beerDataState) {
                is BeerDataState.Loading -> LoadingState()
                is BeerDataState.Error -> ErrorState()
                is BeerDataState.DataLoaded -> BeerListState(
                    favorites = favorites,
                    beerList = beerList,
                    loadMoreData = loadMoreData,
                    showDetails = showDetails,
                    randomBeer = randomBeer,
                    showRandomBeer = showRandomBeer
                )
            }
        }
    }
}

@DefaultLightDarkPreview
@Composable
private fun HomeScreenLoadingPreview() {
    AppNameTheme {
        HomeScreen(
            favorites = emptyList(),
            beerList = emptyList(),
            beerDataState = BeerDataState.Loading,
            showDetails = {},
            loadMoreData = {},
            showRandomBeer = {},
            randomBeer = null
        )
    }
}

@DefaultLightDarkPreview
@Composable
private fun HomeScreenErrorPreview() {
    AppNameTheme {
        HomeScreen(
            favorites = emptyList(),
            beerList = emptyList(),
            beerDataState = BeerDataState.Error(),
            showDetails = {},
            loadMoreData = {},
            showRandomBeer = {},
            randomBeer = null
        )
    }
}

@DefaultLightDarkPreview
@Composable
private fun HomeScreenBeerOverviewPreview() {
    AppNameTheme {
        HomeScreen(
            favorites = listOf(
                BeerUIItem(
                    id = 3,
                    name = "item_3",
                    shortDescription = "description 123",
                    imageUrl = null,
                    tagline = "Tag1, Tag2"
                )
            ),
            beerList = (0..12).map {
                BeerUIItem(
                    id = it,
                    name = "item_$it",
                    shortDescription = "description 123",
                    imageUrl = null,
                    tagline = "Tag1, Tag2"
                )
            },
            beerDataState = BeerDataState.DataLoaded(),
            showDetails = {},
            loadMoreData = {},
            showRandomBeer = {},
            randomBeer = null
        )
    }
}
