
package com.grumpyshoe.beertastic.domain.beer.usecase

import com.grumpyshoe.beertastic.domain.beer.models.Beer
import com.grumpyshoe.beertastic.domain.beer.utils.ApiResult

interface GetRandomBeer {
    suspend operator fun invoke(): ApiResult<Beer>
}
