package com.grumpyshoe.beertastic.data.source.network.beer.datasource

import com.grumpyshoe.beertastic.data.source.network.beer.model.BeerDto
import com.grumpyshoe.beertastic.data.source.network.beer.model.fakeBeerDto
import com.grumpyshoe.beertastic.result.ApiError
import com.grumpyshoe.beertastic.result.ApiResult
import com.grumpyshoe.beertastic.result.ApiSuccess
import com.grumpyshoe.beertastic.result.onError
import com.grumpyshoe.beertastic.result.onSuccess

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

    override suspend fun getBeerById(beerId: Int): ApiResult<BeerDto?> {
        requestedBeerId = beerId
        var parseResult: ApiResult<BeerDto?> = ApiError("Fehler")
        result.onSuccess {
            parseResult = ApiSuccess(it.firstOrNull())
        }
        return parseResult
    }

    override suspend fun getRandomBeer(): ApiResult<BeerDto?> {
        var parserResult: ApiResult<BeerDto?> = ApiError("Fehler")
         result.onSuccess {
             parserResult = ApiSuccess(it.firstOrNull())
         }
        return parserResult
    }
}