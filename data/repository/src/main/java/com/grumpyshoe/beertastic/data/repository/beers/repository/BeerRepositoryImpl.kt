
package com.grumpyshoe.beertastic.data.repository.beers.repository

import android.util.Log
import com.grumpyshoe.beertastic.data.source.network.BuildConfig.BASE_URL
import com.grumpyshoe.beertastic.data.source.network.beer.datasource.BeerRemoteDatasource
import com.grumpyshoe.beertastic.data.source.network.beer.model.BeerDto
import com.grumpyshoe.beertastic.data.source.network.beer.model.IngredientsDto
import com.grumpyshoe.beertastic.data.source.network.beer.model.IngredientsItemDto
import com.grumpyshoe.beertastic.data.source.network.beer.model.MethodDto
import com.grumpyshoe.beertastic.data.source.network.beer.model.MethodItemDto
import com.grumpyshoe.beertastic.data.source.network.beer.model.VolumeDto
import com.grumpyshoe.beertastic.data.source.preferences.SharedPreferenceService
import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.models.Fermentation
import com.grumpyshoe.beertastic.domain.beer.models.Ingredients
import com.grumpyshoe.beertastic.domain.beer.models.IngredientsItem
import com.grumpyshoe.beertastic.domain.beer.models.Method
import com.grumpyshoe.beertastic.domain.beer.models.MethodItem
import com.grumpyshoe.beertastic.domain.beer.models.Value
import com.grumpyshoe.beertastic.domain.beer.models.Volume
import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import com.grumpyshoe.beertastic.domain.beer.utils.ApiResult
import com.grumpyshoe.beertastic.domain.beer.utils.mapResult
import kotlinx.coroutines.flow.Flow

class BeerRepositoryImpl(
    private val beerRemoteDatasource: BeerRemoteDatasource,
    private val sharedPreferenceService: SharedPreferenceService,
) : BeerRepository {
    override suspend fun getBeers(page: Int): ApiResult<List<Beer>> = beerRemoteDatasource.getBeers(page = page).mapResult { dtoList ->
        dtoList.mapNotNull { dto ->
            dto.toBeer()
        }
    }

    override suspend fun getBeerById(beerId: Int): ApiResult<Beer> = beerRemoteDatasource.getBeerById(beerId).mapResult { beerDto ->
        beerDto?.toBeer()
    }

    override suspend fun checkIfFavorite(beerId: Int): Boolean = sharedPreferenceService.checkIfFavorite(beerId)

    override suspend fun setIsBeerFavorite(
        beerId: Int,
        isFavorite: Boolean,
    ) {
        sharedPreferenceService.setIsBeerFavorite(
            beerId = beerId,
            isFavorite = isFavorite,
        )
    }

    override fun getFavorites(): Flow<List<Int>> = sharedPreferenceService.favorites

    override suspend fun getRandomBeer(): ApiResult<Beer> = beerRemoteDatasource.getRandomBeer().mapResult { beerDto ->
        beerDto?.toBeer()
    }
}

internal fun BeerDto.toBeer(): Beer? {
    with(this) {
        try {
            return Beer(
                id = id!!,
                name = name!!,
                tagline = tagline!!,
                firstBrewed = firstBrewed!!,
                description = description!!,
                imageUrl = "${BASE_URL}images/$imageId",
                abv = abv,
                ibu = ibu,
                targetFG = targetFg,
                targetOG = targetOg,
                ebc = ebc,
                srm = srm,
                ph = ph,
                attenuationLevel = attenuationLevel,
                volume = volume?.toVolume(),
                boilVolume = boilVolume?.toVolume(),
                method = method?.toMethod(),
                ingredients = ingredients?.toIngredients(),
                foodPairing = foodPairing,
                brewersTips = brewersTips,
                contributedBy = contributedBy,
            )
        } catch (e: Exception) {
            Log.e("Parser Error", e.localizedMessage, e)
            return null
        }
    }
}

internal fun VolumeDto.toVolume(): Volume? {
    with(this) {
        try {
            return Volume(
                value = value!!,
                unit = unit!!,
            )
        } catch (e: Exception) {
            Log.e("Parser Error", e.localizedMessage, e)
            return null
        }
    }
}

internal fun MethodDto.toMethod(): Method? {
    with(this) {
        try {
            return Method(
                mashTemp = mashTemp?.mapNotNull { it.toMethodItem() }!!,
                fermentation =
                fermentation?.let {
                    Fermentation(
                        temp =
                        Value(
                            value = it.temp?.value ?: return null,
                            unit = it.temp?.unit ?: return null,
                        ),
                    )
                }!!,
                twist = twist,
            )
        } catch (e: Exception) {
            Log.e("Parser Error", e.localizedMessage, e)
            return null
        }
    }
}

internal fun MethodItemDto.toMethodItem(): MethodItem? {
    with(this) {
        try {
            return MethodItem(
                temp =
                Value(
                    value = temp!!.value!!,
                    unit = temp!!.unit!!,
                ),
                duration = duration,
            )
        } catch (e: Exception) {
            Log.e("Parser Error", e.localizedMessage, e)
            return null
        }
    }
}

internal fun IngredientsDto.toIngredients(): Ingredients? {
    with(this) {
        try {
            return Ingredients(
                malt =
                malt?.mapNotNull {
                    it.toIngredientsItem()
                },
                hops =
                hops?.mapNotNull {
                    it.toIngredientsItem()
                },
                yeast = yeast,
            )
        } catch (e: Exception) {
            Log.e("Parser Error", e.localizedMessage, e)
            return null
        }
    }
}

internal fun IngredientsItemDto.toIngredientsItem(): IngredientsItem? {
    with(this) {
        try {
            return IngredientsItem(
                name = name!!,
                amount =
                Value(
                    value = amount!!.value!!,
                    unit = amount!!.unit!!,
                ),
                add = add,
                attribute = attribute,
            )
        } catch (e: Exception) {
            Log.e("Parser Error", e.localizedMessage, e)
            return null
        }
    }
}
