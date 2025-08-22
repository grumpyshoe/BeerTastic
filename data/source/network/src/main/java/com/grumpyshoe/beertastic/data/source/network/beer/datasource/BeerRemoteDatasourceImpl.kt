package com.grumpyshoe.beertastic.data.source.network.beer.datasource

import com.grumpyshoe.beertastic.data.source.network.beer.api.PunkAPI
import com.grumpyshoe.beertastic.data.source.network.beer.model.BeerDto
import com.grumpyshoe.beertastic.data.source.network.handleApi
import com.grumpyshoe.beertastic.result.ApiResult
import javax.inject.Inject

class BeerRemoteDatasourceImpl @Inject constructor(
    private val api: PunkAPI,
) : BeerRemoteDatasource {

    override suspend fun getBeers(page: Int): ApiResult<List<BeerDto>> {
        return handleApi { api.getBeers(page = page) }
    }

    override suspend fun getBeerById(beerId: Int): ApiResult<BeerDto> {
        return handleApi { api.getBeerById(beerId) }
    }

    override suspend fun getRandomBeer(): ApiResult<BeerDto?> {
        return handleApi { api.getRandomBeer() }
    }
}
