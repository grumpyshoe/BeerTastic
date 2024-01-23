package com.grumpyshoe.beertastic.data.source.network.beer.datasource

import com.grumpyshoe.beertastic.data.source.network.beer.model.BeerDto
import com.grumpyshoe.beertastic.data.source.network.beer.model.fakeBeerDto
import com.grumpyshoe.beertastic.result.ApiResult
import com.grumpyshoe.beertastic.result.ApiSuccess

class FakeBeerRemoteDatasource : BeerRemoteDatasource {

    var result: ApiResult<List<BeerDto>> = ApiSuccess(listOf(fakeBeerDto))
    var requestedPage: Int? = null
        private set
    var requestedBeerId: Int? = null
        private set

    override suspend fun getBeers(page: Int): ApiResult<List<BeerDto>> {
        requestedPage = page
        return result
    }

    override suspend fun getBeerById(beerId: Int): ApiResult<List<BeerDto>> {
        requestedBeerId = beerId
        return result
    }

    // TEST REQUIRED
    override suspend fun getRandomBeer(): ApiResult<List<BeerDto>> {
        return result
    }
}