package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.models.fakeBeer
import com.grumpyshoe.beertastic.domain.beer.utils.ApiResult
import com.grumpyshoe.beertastic.domain.beer.utils.ApiSuccess

class FakeGetRandomBeer : GetRandomBeer {

    var result: ApiResult<Beer> = ApiSuccess(fakeBeer)

    override suspend fun invoke(): ApiResult<Beer> = result
}
