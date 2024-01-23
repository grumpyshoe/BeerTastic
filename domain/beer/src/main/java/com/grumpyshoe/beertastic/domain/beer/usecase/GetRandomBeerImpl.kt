package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import com.grumpyshoe.beertastic.result.ApiResult
import javax.inject.Inject

class GetRandomBeerImpl @Inject constructor(
    private val beerRepository: BeerRepository,
) : GetRandomBeer {

    override suspend fun invoke(): ApiResult<Beer> {
        return beerRepository.getRandomBeer()
    }
}
