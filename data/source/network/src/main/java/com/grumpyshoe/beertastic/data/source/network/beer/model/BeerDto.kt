package com.grumpyshoe.beertastic.data.source.network.beer.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BeerDto(
    val id: Int? = null,
    val name: String? = null,
    val tagline: String? = null,
    @field:Json(name = "first_brewed")
    val firstBrewed: String? = null,
    val description: String? = null,
    @field:Json(name = "image_url")
    val imageUrl: String? = null,
    val abv: Double? = null,
    val ibu: Double? = null,
    @field:Json(name = "target_fg")
    val targetFg: Double? = null,
    @field:Json(name = "target_og")
    val targetOg: Double? = null,
    val ebc: Double? = null,
    val srm: Double? = null,
    val ph: Double? = null,
    @field:Json(name = "attenuation_level")
    val attenuationLevel: Double? = null,
    val volume: VolumeDto? = null,
    @field:Json(name = "boil_volume")
    val boilVolume: VolumeDto? = null,
    val method: MethodDto? = null,
    val ingredients: IngredientsDto? = null,
    @field:Json(name = "food_pairing")
    val foodPairing: List<String>? = null,
    @field:Json(name = "brewers_tips")
    val brewersTips: String? = null,
    @field:Json(name = "contributed_by")
    val contributedBy: String? = null
)

@JsonClass(generateAdapter = true)
data class VolumeDto(
    val value: Int? = null,
    val unit: String? = null,
)

@JsonClass(generateAdapter = true)
data class MethodDto(
    @field:Json(name = "mash_temp")
    val mashTemp: List<MethodItemDto>? = null,
    val fermentation: FermentationDto? = null,
    val twist: String? = null
)

@JsonClass(generateAdapter = true)
data class MethodItemDto(
    val temp: ValueDto? = null,
    val duration: Int? = null,
)

@JsonClass(generateAdapter = true)
data class FermentationDto(
    val temp: ValueDto? = null,
)

@JsonClass(generateAdapter = true)
data class ValueDto(
    val value: Double? = null,
    val unit: String? = null
)

@JsonClass(generateAdapter = true)
data class IngredientsDto(
    val malt: List<IngredientsItemDto>? = null,
    val hops: List<IngredientsItemDto>? = null,
    val yeast: String? = null
)

@JsonClass(generateAdapter = true)
data class IngredientsItemDto(
    val name: String? = null,
    val amount: ValueDto? = null,
    val add: String? = null,
    val attribute: String? = null,
)