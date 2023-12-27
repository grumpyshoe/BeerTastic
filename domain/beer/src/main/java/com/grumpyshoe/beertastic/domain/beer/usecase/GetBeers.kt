package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.result.ApiResult

interface GetBeers {
    suspend operator fun invoke(page: Int): ApiResult<List<Beer>>
}
