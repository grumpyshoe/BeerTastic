
package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import com.grumpyshoe.beertastic.domain.beer.utils.ApiResult

class GetBeerByIdImpl(
    private val beerRepository: BeerRepository,
) : GetBeerById {
    override suspend fun invoke(beerId: Int): ApiResult<Beer> = beerRepository.getBeerById(beerId = beerId)
}
