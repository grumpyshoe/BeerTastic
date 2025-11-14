
package com.grumpyshoe.beertastic.domain.beer.usecase

interface SetIsBeerFavorite {
    suspend operator fun invoke(
        beerId: Int,
        isFavorite: Boolean,
    )
}
