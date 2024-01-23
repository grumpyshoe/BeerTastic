package com.grumpyshoe.beertastic.data.source.network.beer.datasource

import com.grumpyshoe.beertastic.data.source.network.beer.model.BeerDto
import com.grumpyshoe.beertastic.result.ApiResult

interface BeerRemoteDatasource {
    suspend fun getBeers(page: Int): ApiResult<List<BeerDto>>
    suspend fun getBeerById(beerId: Int): ApiResult<List<BeerDto>>
    suspend fun getRandomBeer(): ApiResult<List<BeerDto>>
}
