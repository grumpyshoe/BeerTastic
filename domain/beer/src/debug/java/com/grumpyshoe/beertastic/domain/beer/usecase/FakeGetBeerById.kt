package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.models.fakeBeer
import com.grumpyshoe.beertastic.result.ApiResult
import com.grumpyshoe.beertastic.result.ApiSuccess

class FakeGetBeerById : GetBeerById {

    var result: ApiResult<Beer> = ApiSuccess(fakeBeer)
    var requestedBeerId: Int? = null
        private set

    override suspend fun invoke(beerId: Int): ApiResult<Beer> {
        requestedBeerId = beerId
        return result
    }
}
