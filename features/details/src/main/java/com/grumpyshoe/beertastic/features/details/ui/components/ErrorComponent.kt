package com.grumpyshoe.beertastic.features.details.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.grumpyshoe.beertastic.common.resources.R
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppNameTheme
import com.grumpyshoe.common.ui.DefaultLightDarkPreview

@Composable
internal fun ErrorComponent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        contentAlignment = Alignment.Center,
    ) {
        Card {
            Box(modifier = Modifier.padding(16.dp)) {
                Text(stringResource(R.string.home_loading_error))
            }
        }
    }
}

@DefaultLightDarkPreview
@Composable
private fun ErrorComponentPreview() {
    AppNameTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            ErrorComponent()
        }
    }
}