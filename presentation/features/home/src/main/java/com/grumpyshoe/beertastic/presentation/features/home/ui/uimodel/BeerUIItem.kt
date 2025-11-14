
package com.grumpyshoe.beertastic.presentation.features.home.ui.uimodel

import androidx.compose.runtime.Immutable

@Immutable
data class BeerUIItem(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val imageUrl: String?,
    val tagline: String,
)
