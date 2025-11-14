
package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.utils.ApiResult

interface GetBeerById {
    suspend operator fun invoke(beerId: Int): ApiResult<Beer>
}
