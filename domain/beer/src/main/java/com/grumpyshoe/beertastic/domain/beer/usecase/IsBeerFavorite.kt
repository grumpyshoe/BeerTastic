package com.grumpyshoe.beertastic.domain.beer.usecase

interface IsBeerFavorite {
    suspend operator fun invoke(beerId: Int): Boolean
}
