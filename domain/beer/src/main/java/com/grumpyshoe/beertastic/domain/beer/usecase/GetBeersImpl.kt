package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import com.grumpyshoe.beertastic.result.ApiResult
import javax.inject.Inject

class GetBeersImpl @Inject constructor(
    private val beerRepository: BeerRepository,
) : GetBeers {

    override suspend fun invoke(page: Int): ApiResult<List<Beer>> {
        return beerRepository.getBeers(page = page)
    }
}
