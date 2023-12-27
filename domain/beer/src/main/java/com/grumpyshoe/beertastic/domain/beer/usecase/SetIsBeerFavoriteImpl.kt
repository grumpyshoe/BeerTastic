package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import javax.inject.Inject

class SetIsBeerFavoriteImpl @Inject constructor(
    private val beerRepository: BeerRepository,
) : SetIsBeerFavorite {

    override suspend fun invoke(
        beerId: Int,
        isFavorite: Boolean
    ) {
        beerRepository.setIsBeerFavorite(
            beerId = beerId,
            isFavorite = isFavorite
        )
    }
}
