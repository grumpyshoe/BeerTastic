
package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import com.grumpyshoe.beertastic.domain.beer.utils.ApiResult

class GetRandomBeerImpl(private val beerRepository: BeerRepository) : GetRandomBeer {
    override suspend fun invoke(): ApiResult<Beer> = beerRepository.getRandomBeer()
}
