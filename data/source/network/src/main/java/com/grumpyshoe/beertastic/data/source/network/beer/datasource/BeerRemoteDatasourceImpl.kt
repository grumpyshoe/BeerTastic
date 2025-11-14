
package com.grumpyshoe.beertastic.data.source.network.beer.datasource

import com.grumpyshoe.beertastic.data.source.network.beer.api.PunkAPI
import com.grumpyshoe.beertastic.data.source.network.beer.model.BeerDto
import com.grumpyshoe.beertastic.data.source.network.handleApi
import com.grumpyshoe.beertastic.domain.beer.utils.ApiResult

class BeerRemoteDatasourceImpl(
    private val api: PunkAPI,
) : BeerRemoteDatasource {
    override suspend fun getBeers(page: Int): ApiResult<List<BeerDto>> = handleApi { api.getBeers(page = page) }

    override suspend fun getBeerById(beerId: Int): ApiResult<BeerDto> = handleApi {
        api.getBeerById(beerId)
    }

    override suspend fun getRandomBeer(): ApiResult<BeerDto?> = handleApi { api.getRandomBeer() }
}
