
package com.grumpyshoe.beertastic.data.source.network.beer.model

import com.google.gson.annotations.SerializedName

data class BeerDto(
    val id: Int? = null,
    val name: String? = null,
    val tagline: String? = null,
    @SerializedName("first_brewed") val firstBrewed: String? = null,
    val description: String? = null,
    @SerializedName("image") val imageId: String? = null,
    val abv: Double? = null,
    val ibu: Double? = null,
    @SerializedName("target_fg") val targetFg: Double? = null,
    @SerializedName("target_og") val targetOg: Double? = null,
    val ebc: Double? = null,
    val srm: Double? = null,
    val ph: Double? = null,
    @SerializedName("attenuation_level") val attenuationLevel: Double? = null,
    val volume: VolumeDto? = null,
    @SerializedName("boil_volume") val boilVolume: VolumeDto? = null,
    val method: MethodDto? = null,
    val ingredients: IngredientsDto? = null,
    @SerializedName("food_pairing") val foodPairing: List<String>? = null,
    @SerializedName("brewers_tips") val brewersTips: String? = null,
    @SerializedName("contributed_by") val contributedBy: String? = null,
)

data class VolumeDto(
    val value: Int? = null,
    val unit: String? = null,
)

data class MethodDto(
    @SerializedName("mash_temp") val mashTemp: List<MethodItemDto>? = null,
    val fermentation: FermentationDto? = null,
    val twist: String? = null,
)

data class MethodItemDto(
    val temp: ValueDto? = null,
    val duration: Int? = null,
)

data class FermentationDto(
    val temp: ValueDto? = null,
)

data class ValueDto(
    val value: Double? = null,
    val unit: String? = null,
)

data class IngredientsDto(
    val malt: List<IngredientsItemDto>? = null,
    val hops: List<IngredientsItemDto>? = null,
    val yeast: String? = null,
)

data class IngredientsItemDto(
    val name: String? = null,
    val amount: ValueDto? = null,
    val add: String? = null,
    val attribute: String? = null,
)
