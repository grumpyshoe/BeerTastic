package com.grumpyshoe.beertastic.presentation.features.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.grumpyshoe.beertastic.common.resources.R
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppTheme
import com.grumpyshoe.beertastic.presentation.features.home.ui.uimodel.BeerUIItem

@Composable
fun RandomBeer(
    randomBeer: BeerUIItem?,
    showRandomBeer: () -> Unit,
    hideRandomBeer: () -> Unit,
    showDetails: (Int) -> Unit,
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceContainerHigh,
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        var loading by remember { mutableStateOf(false) }

        LaunchedEffect(randomBeer) {
            if (randomBeer != null) {
                loading = false
            }
        }

        if (randomBeer == null) {
            DiscoverCard(
                showRandomBeer = showRandomBeer,
                updateLoading = { loading = it },
            )
        } else {
            BeerSuggestion(
                isLoading = loading,
                randomBeer = randomBeer,
                showDetails = showDetails,
                showRandomBeer = showRandomBeer,
                hideSuggestion = hideRandomBeer,
                updateLoading = {
                    loading = it
                },
            )
        }
    }
}

@Composable
private fun BeerSuggestion(
    isLoading: Boolean,
    randomBeer: BeerUIItem,
    showDetails: (Int) -> Unit,
    showRandomBeer: () -> Unit,
    hideSuggestion: () -> Unit,
    updateLoading: (Boolean) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp),
    ) {
        Text(
            text = randomBeer.name,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Spacer(Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .background(AppTheme.colors.material.surface.copy(alpha = .6f), CircleShape)
                .padding(8.dp)
                .size(96.dp),
            contentAlignment = Alignment.Center,
        ) {
            if (randomBeer.imageUrl != null) {
                if (isLoading) {
                    CircularProgressIndicator()
                } else {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(randomBeer.imageUrl)
                            .crossfade(true)
                            .build(),
                        contentScale = ContentScale.FillWidth,
                        placeholder = painterResource(R.drawable.questionmark),
                        contentDescription = randomBeer.name,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                            .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)
                            .padding(horizontal = 8.dp),
                    )
                }
            } else {
                Image(
                    modifier = Modifier.size(70.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.questionmark),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(AppTheme.colors.material.onSurface),
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = randomBeer.shortDescription,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        Spacer(Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = {
                    showDetails(randomBeer.id)
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(50),
            ) {
                Text("See more details...")
            }

            Spacer(Modifier.width(16.dp))

            OutlinedIconButton(
                onClick = {
                    updateLoading(true)
                    showRandomBeer()
                },
                shape = CircleShape,
            ) {
                Icon(Icons.Default.Refresh, contentDescription = "Refresh")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            TextButton(onClick = hideSuggestion) {
                Text("Close suggestion")
            }
        }
    }
}

@Composable
private fun DiscoverCard(showRandomBeer: () -> Unit, updateLoading: (Boolean) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp),
    ) {
        Text(
            text = "Ready to discover your new\nfavorite beer?",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Spacer(Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = .6f))
                .padding(12.dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(5.dp, 0.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            )
            Image(
                modifier = Modifier.size(72.dp),
                painter = painterResource(R.drawable.questionmark),
                contentDescription = null,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Be inspired — discover beers that suit\nyour taste!",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Spacer(Modifier.height(16.dp))
        OutlinedButton(
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            ),
            onClick = {
                updateLoading(true)
                showRandomBeer()
            },
        ) {
            Text("Start your adventure now!")
        }
    }
}

@PreviewLightDark
@Composable
private fun RandomBeer_suggetion() {
    AppTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            RandomBeer(
                randomBeer = BeerUIItem(
                    id = 3,
                    name = "The Emperors Blue Clothes (BD vs People Like Us)",
                    shortDescription = "Brewed in collaboration with People Like Us, this ...",
                    imageUrl = null,
                    tagline = "Tag1, Tag2",
                ),
                showRandomBeer = {},
                hideRandomBeer = {},
                showDetails = {},
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun RandomBeer_init_state() {
    AppTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            RandomBeer(
                randomBeer = null,
                showRandomBeer = {},
                hideRandomBeer = {},
                showDetails = {},
            )
        }
    }
}
