package com.grumpyshoe.beertastic.features.home.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.grumpyshoe.beertastic.common.resources.R
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppNameTheme
import com.grumpyshoe.beertastic.features.home.ui.uimodel.BeerUIItem
import com.grumpyshoe.common.ui.DefaultLightDarkPreview
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun BeerListComponent(
    favorites: List<BeerUIItem>?,
    beerList: List<BeerUIItem>,
    loadMoreData: () -> Unit,
    showDetails: (Int) -> Unit
) {
    var loading by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collectLatest { index ->
                if (!loading && index != null && index >= beerList.size - 5) {
                    loadMoreData()
                    loading = true
                }
            }
    }
    LaunchedEffect(beerList) {
        loading = false
    }

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {

        if (!favorites.isNullOrEmpty()) {

            item {
                SectionHeadline(R.string.home_section_favorites)

                Spacer(modifier = Modifier.height(8.dp))
            }

            items(favorites) { beerUIItem ->

                BeerUIItemView(
                    beerItem = beerUIItem,
                    showDetails = showDetails,
                    borderStrokeColor = MaterialTheme.colorScheme.primary
                )
            }
        }

        if (beerList.isNotEmpty()) {

            item {
                SectionHeadline(R.string.home_section_all_beers)

                Spacer(modifier = Modifier.height(8.dp))
            }

            items(items = beerList, key = { it.id }) { beerUIItem ->

                BeerUIItemView(
                    beerItem = beerUIItem,
                    showDetails = showDetails
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BeerUIItemView(
    beerItem: BeerUIItem,
    showDetails: (Int) -> Unit,
    borderStrokeColor: Color = MaterialTheme.colorScheme.surface
) {
    Box(modifier = Modifier.padding(bottom = 16.dp)) {
        Card(
            border = BorderStroke(2.dp, color = borderStrokeColor),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Box(modifier = Modifier.padding(vertical = 8.dp)) {
                ListItem(
                    modifier = Modifier
                        .clickable {
                            showDetails(beerItem.id)
                        },
                    leadingContent = {
                        Box(
                            modifier = Modifier.size(56.dp),
                            contentAlignment = Alignment.Center,
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(beerItem.imageUrl)
                                    .crossfade(true)
                                    .build(),
                                contentDescription = beerItem.name,
                            )
                        }
                    },
                    headlineText = {
                        Text(text = beerItem.name)
                    },
                    supportingText = {
                        Text(beerItem.tagline)
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
        }
    }
}

@Composable
private fun SectionHeadline(@StringRes text: Int) {
    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@DefaultLightDarkPreview
@Composable
private fun BeerListComponentPreview() {
    AppNameTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            BeerListComponent(
                favorites = listOf(
                    BeerUIItem(
                        id = 3,
                        name = "item_3",
                        shortDescription = "description 123",
                        imageUrl = null,
                        tagline = "Tag1, Tag2"
                    )
                ),
                showDetails = {},
                beerList = (0..12).map {
                    BeerUIItem(
                        id = it,
                        name = "item_$it",
                        shortDescription = "description 123",
                        imageUrl = null,
                        tagline = "Tag1, Tag2"
                    )
                },
                loadMoreData = {},
            )
        }
    }
}