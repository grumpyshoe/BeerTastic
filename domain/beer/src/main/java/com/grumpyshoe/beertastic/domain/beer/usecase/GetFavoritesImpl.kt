
package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import kotlinx.coroutines.flow.Flow

class GetFavoritesImpl(private val beerRepository: BeerRepository) : GetFavorites {
    override fun invoke(): Flow<List<Int>> = beerRepository.getFavorites()
}
