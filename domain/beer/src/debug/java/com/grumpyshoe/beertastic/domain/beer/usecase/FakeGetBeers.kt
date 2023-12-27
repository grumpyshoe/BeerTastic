package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.models.fakeBeer
import com.grumpyshoe.beertastic.result.ApiResult
import com.grumpyshoe.beertastic.result.ApiSuccess

class FakeGetBeers : GetBeers {

    var result: ApiResult<List<Beer>> = ApiSuccess(listOf(fakeBeer))
    var requestedPage: Int? = null
        private set

    override suspend fun invoke(page: Int): ApiResult<List<Beer>> {
        requestedPage = page
        return result
    }
}
