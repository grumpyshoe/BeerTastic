
package com.grumpyshoe.beertastic.domain.beer.usecase

import kotlinx.coroutines.flow.Flow

interface GetFavorites {
    operator fun invoke(): Flow<List<Int>>
}
