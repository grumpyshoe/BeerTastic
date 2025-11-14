
package com.grumpyshoe.beertastic.domain.beer.models

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val firstBrewed: String,
    val description: String,
    val imageUrl: String?,
    val abv: Double?,
    val ibu: Double?,
    val targetFG: Double?,
    val targetOG: Double?,
    val ebc: Double?,
    val srm: Double?,
    val ph: Double?,
    val attenuationLevel: Double?,
    val volume: Volume?,
    val boilVolume: Volume?,
    val method: Method?,
    val ingredients: Ingredients?,
    val foodPairing: List<String>?,
    val brewersTips: String?,
    val contributedBy: String?,
)

data class Volume(
    val value: Int,
    val unit: String,
)

data class Method(
    val mashTemp: List<MethodItem>,
    val fermentation: Fermentation,
    val twist: String?,
)

data class MethodItem(
    val temp: Value,
    val duration: Int?,
)

data class Fermentation(
    val temp: Value,
)

data class Value(
    val value: Double,
    val unit: String,
)

data class Ingredients(
    val malt: List<IngredientsItem>?,
    val hops: List<IngredientsItem>?,
    val yeast: String?,
)

data class IngredientsItem(
    val name: String,
    val amount: Value,
    val add: String? = null,
    val attribute: String? = null,
)
