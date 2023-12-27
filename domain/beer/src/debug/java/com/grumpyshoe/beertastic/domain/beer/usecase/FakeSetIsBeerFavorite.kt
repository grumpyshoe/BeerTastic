package com.grumpyshoe.beertastic.domain.beer.usecase

class FakeSetIsBeerFavorite : SetIsBeerFavorite {

    var requestedBeerId: Int? = null
        private set

    override suspend fun invoke(beerId: Int, isFavorite: Boolean) {
        requestedBeerId = beerId
    }
}
