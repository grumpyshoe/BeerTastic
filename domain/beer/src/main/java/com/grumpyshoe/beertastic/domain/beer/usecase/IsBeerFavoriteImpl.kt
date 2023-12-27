package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import javax.inject.Inject

class IsBeerFavoriteImpl @Inject constructor(
    private val beerRepository: BeerRepository,
) : IsBeerFavorite {

    override suspend fun invoke(beerId: Int): Boolean {
        return beerRepository.checkIfFavorite(beerId = beerId)
    }
}
