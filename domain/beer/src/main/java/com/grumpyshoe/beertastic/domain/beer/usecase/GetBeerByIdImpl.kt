package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import com.grumpyshoe.beertastic.result.ApiResult
import javax.inject.Inject

class GetBeerByIdImpl @Inject constructor(
    private val beerRepository: BeerRepository,
) : GetBeerById {

    override suspend fun invoke(beerId: Int): ApiResult<Beer> {
        return beerRepository.getBeerById(beerId = beerId)
    }
}
