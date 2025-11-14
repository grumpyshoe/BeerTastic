
package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import com.grumpyshoe.beertastic.domain.beer.utils.ApiResult

class GetBeersImpl(
    private val beerRepository: BeerRepository,
) : GetBeers {
    override suspend fun invoke(page: Int): ApiResult<List<Beer>> = beerRepository.getBeers(page = page)
}
