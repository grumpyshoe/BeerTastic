package com.grumpyshoe.beertastic.features.details.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.grumpyshoe.beertastic.common.resources.R
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppNameTheme
import com.grumpyshoe.beertastic.features.details.ui.uimodel.BeerDetailUIItem
import com.grumpyshoe.common.ui.DefaultLightDarkPreview


@Composable
internal fun DetailsDataComponent(beerDetails: BeerDetailUIItem) {
    val scrollSate = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollSate)
            .padding(16.dp)
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = beerDetails.name,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = beerDetails.tagline,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.outline
        )

        Box(
            Modifier
                .fillMaxWidth()
                .heightIn(max = 240.dp)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(beerDetails.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = beerDetails.name,
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 24.dp),
            text = beerDetails.description,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.outline
        )

        SectionHeadline(R.string.details_section_general)

        Spacer(modifier = Modifier.heightIn(8.dp))

        SectionEntry(
            label = R.string.details_section_entry_first_brewed,
            value = beerDetails.firstBrewed
        )
        SectionEntry(
            label = R.string.details_section_entry_abv,
            value = beerDetails.abv
        )
        SectionEntry(
            label = R.string.details_section_entry_ibu,
            value = beerDetails.ibu
        )
        SectionEntry(
            label = R.string.details_section_entry_targetFG,
            value = beerDetails.targetFG
        )
        SectionEntry(
            label = R.string.details_section_entry_targetOG,
            value = beerDetails.targetOG
        )
        SectionEntry(
            label = R.string.details_section_entry_ebc,
            value = beerDetails.ebc
        )
        SectionEntry(
            label = R.string.details_section_entry_srm,
            value = beerDetails.srm
        )
        SectionEntry(
            label = R.string.details_section_entry_ph,
            value = beerDetails.ph
        )
        SectionEntry(
            label = R.string.details_section_entry_attenuationLevel,
            value = beerDetails.attenuationLevel
        )
        SectionEntry(
            label = R.string.details_section_entry_volume,
            value = beerDetails.volume
        )
        SectionEntry(
            label = R.string.details_section_entry_boilVolume,
            value = beerDetails.boilVolume
        )

        Spacer(modifier = Modifier.heightIn(24.dp))

        SectionHeadline(R.string.details_section_method)

        Spacer(modifier = Modifier.heightIn(8.dp))

        beerDetails.method.forEach { entry ->
            SectionEntry(value = entry)
        }

        Spacer(modifier = Modifier.heightIn(24.dp))

        SectionHeadline(R.string.details_section_ingredients)

        Spacer(modifier = Modifier.heightIn(8.dp))

        beerDetails.ingredients.forEach { entry ->
            SectionEntry(value = entry)
        }

        Spacer(modifier = Modifier.heightIn(24.dp))

        SectionHeadline(R.string.details_section_food_pairing)

        Spacer(modifier = Modifier.heightIn(8.dp))

        beerDetails.foodPairing.forEach { entry ->
            SectionEntry(value = entry)
        }

        Spacer(modifier = Modifier.heightIn(24.dp))

        SectionHeadline(R.string.details_section_brewer_tips)

        Spacer(modifier = Modifier.heightIn(8.dp))

        SectionEntry(value = beerDetails.brewersTips)

        Spacer(modifier = Modifier.heightIn(24.dp))

        SectionHeadline(R.string.details_section_contributed_by)

        Spacer(modifier = Modifier.heightIn(8.dp))

        SectionEntry(value = beerDetails.contributedBy)
    }
}

@Composable
private fun SectionHeadline(@StringRes text: Int) {
    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.outlineVariant
    )
}

@Composable
private fun SectionEntry(@StringRes label: Int? = null, value: String) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        label?.let {
            Text(
                text = stringResource(id = label),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@DefaultLightDarkPreview
@Composable
private fun DetailsDataComponentPreview() {
    AppNameTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            DetailsDataComponent(
                beerDetails = BeerDetailUIItem(
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
                        "Fermentation - 19°C - "
                    ),
                    ingredients = listOf(
                        "malt - Extra Pale - 5.3Kg",
                        "hops - Ahtanum - 17.5g",
                        "hops - Chinook - 15g - start - (bitter)"
                    ),
                    foodPairing = listOf(
                        "Spicy carne asada with a pico de gallo sauce",
                        "Shredded chicken tacos with a mango chilli lime salsa",
                        "Cheesecake with a passion fruit swirl sauce"
                    ),
                    brewersTips = "brewer tips",
                    contributedBy = "Sam Mason <samjbmason>"
                )
            )
        }
    }
}