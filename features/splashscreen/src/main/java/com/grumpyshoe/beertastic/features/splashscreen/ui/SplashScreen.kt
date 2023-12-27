package com.grumpyshoe.beertastic.features.splashscreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.grumpyshoe.beertastic.common.resources.R
import com.grumpyshoe.beertastic.common.resources.ui.theme.AppNameTheme
import com.grumpyshoe.beertastic.features.splashscreen.state.SplashState
import com.grumpyshoe.beertastic.features.splashscreen.viewmodel.SplashViewModel
import com.grumpyshoe.common.ui.DefaultLightDarkPreview

@Composable
internal fun SplashRoute(
    viewModel: SplashViewModel = hiltViewModel(),
    navigateForward: () -> Unit
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(state) {
        if (state is SplashState.Navigate) {
            navigateForward()
        }
    }

    SplashScreen()
}

@Composable
internal fun SplashScreen() {

    Box(
        contentAlignment = BiasAlignment(0f, 0f),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Column {

            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary, shape = CircleShape)
                    .wrapContentSize()
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painterResource(R.drawable.logo),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        style = MaterialTheme.typography.displayLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        text = stringResource(id = R.string.splashscreen_title)
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                text = stringResource(R.string.splashscreen_showcase_text),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                text = stringResource(R.string.splashscreen_author),
                textAlign = TextAlign.Center
            )

        }
    }
}

@DefaultLightDarkPreview
@Composable
private fun HomeScreenPreview() {
    AppNameTheme {
        SplashScreen()
    }
}
