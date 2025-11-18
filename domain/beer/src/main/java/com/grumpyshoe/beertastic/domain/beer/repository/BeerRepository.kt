
package com.grumpyshoe.beertastic.domain.beer.repository

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.utils.ApiResult
import kotlinx.coroutines.flow.Flow

interface BeerRepository {
    suspend fun getBeers(page: Int): ApiResult<List<Beer>>

    suspend fun getBeerById(beerId: Int): ApiResult<Beer>

    suspend fun checkIfFavorite(beerId: Int): Boolean

    suspend fun setIsBeerFavorite(beerId: Int, isFavorite: Boolean)

    fun getFavorites(): Flow<List<Int>>

    suspend fun getRandomBeer(): ApiResult<Beer>
}
