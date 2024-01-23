package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.models.fakeBeer
import com.grumpyshoe.beertastic.result.ApiResult
import com.grumpyshoe.beertastic.result.ApiSuccess

class FakeGetRandomBeer : GetRandomBeer {

    var result: ApiResult<Beer> = ApiSuccess(fakeBeer)

    override suspend fun invoke(): ApiResult<Beer> {
        return result
    }
}
