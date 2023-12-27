package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetFavoritesImpl @Inject constructor(
    private val beerRepository: BeerRepository,
) : GetFavorites {

    override fun invoke(): Flow<List<Int>> {
        return beerRepository.getFavorites()
    }
}
