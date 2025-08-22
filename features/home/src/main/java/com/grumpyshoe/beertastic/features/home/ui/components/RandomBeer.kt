package com.grumpyshoe.beertastic.features.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.grumpyshoe.beertastic.common.resources.R
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppNameTheme
import com.grumpyshoe.beertastic.features.home.ui.uimodel.BeerUIItem
import com.grumpyshoe.common.ui.DefaultLightDarkPreview

@Composable
fun RandomBeer(
    randomBeer: BeerUIItem?,
    showRandomBeer: () -> Unit,
    hideRandomBeer: () -> Unit,
    showDetails: (Int) -> Unit,
) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var loading by remember { mutableStateOf(false) }

            LaunchedEffect(randomBeer) {
                if (randomBeer != null) {
                    loading = false
                }
            }

            if (randomBeer == null) {

                Text(
                    text = "Searching for a new taste?",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(16.dp))
            } else {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopEnd
                ) {
                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape),
                        onClick = {
                            loading = true
                            hideRandomBeer()
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    )
                }
                Text(
                    text = randomBeer.name,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .size(96.dp)
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = .3f), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {

                    Box(
                        modifier = Modifier.size(72.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        if (randomBeer.imageUrl != null) {
                            if (loading) {
                                CircularProgressIndicator()
                            } else {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(randomBeer.imageUrl)
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = randomBeer.name,
                                )
                            }
                        } else {
                            Image(
                                modifier = Modifier.size(70.dp),
                                contentScale = ContentScale.Crop,
                                painter = painterResource(id = R.drawable.questionmark),
                                contentDescription = null
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 72.dp),
                    text = randomBeer.shortDescription,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    OutlinedButton(
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            contentColor = MaterialTheme.colorScheme.primaryContainer,
                        ),
                        onClick = {
                            showDetails(randomBeer.id)
                        }
                    ) {
                        Text("See more details...")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(
                                1.dp, MaterialTheme
                                    .colorScheme.onPrimaryContainer, CircleShape
                            ),
                        onClick = {
                            loading = true
                            showRandomBeer()
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            if (randomBeer == null) {
                OutlinedButton(
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    ),
                    onClick = {
                        loading = true
                        showRandomBeer()
                    }
                ) {
                    Text("Show my something new")
                }
            }
        }
    }
}

@DefaultLightDarkPreview
@Composable
private fun RandomBeerInitStatePreview() {
    AppNameTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            RandomBeer(
                randomBeer = null,
                showRandomBeer = {},
                hideRandomBeer = {},
                showDetails = {}
            )
        }
    }
}

@DefaultLightDarkPreview
@Composable
private fun RandomBeerWithBeerPreview() {
    AppNameTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            RandomBeer(
                randomBeer = BeerUIItem(
                    id = 3,
                    name = "item_3",
                    shortDescription = "description 123",
                    imageUrl = null,
                    tagline = "Tag1, Tag2"
                ),
                showRandomBeer = {},
                hideRandomBeer = {},
                showDetails = {}
            )
        }
    }
}