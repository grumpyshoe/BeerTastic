package com.grumpyshoe.beertastic.domain.beer.usecase
class FakeIsBeerFavorite : IsBeerFavorite {

    var result: Boolean = false
    var requestedBeerId: Int? = null
        private set

    override suspend fun invoke(beerId: Int): Boolean {
        requestedBeerId = beerId
        return result
    }
}
