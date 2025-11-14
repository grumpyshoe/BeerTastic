
package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository

class IsBeerFavoriteImpl(
    private val beerRepository: BeerRepository,
) : IsBeerFavorite {
    override suspend fun invoke(beerId: Int): Boolean = beerRepository.checkIfFavorite(beerId = beerId)
}
