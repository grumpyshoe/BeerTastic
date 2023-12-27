package com.grumpyshoe.beertastic.features.details.ui.uimodel

import androidx.compose.runtime.Immutable

@Immutable
data class BeerDetailUIItem(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val imageUrl: String?,
    val firstBrewed: String,
    val abv: String,
    val ibu: String,
    val targetFG: String,
    val targetOG: String,
    val ebc: String,
    val srm: String,
    val ph: String,
    val attenuationLevel: String,
    val volume: String,
    val boilVolume: String,
    val method: List<String>,
    val ingredients: List<String>,
    val foodPairing: List<String>,
    val brewersTips: String,
    val contributedBy: String
)
