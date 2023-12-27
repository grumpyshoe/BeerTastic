package com.grumpyshoe.beertastic.domain.beer.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeGetFavorites : GetFavorites {

    var result: List<Int> = listOf()

    override fun invoke(): Flow<List<Int>> = flow { emit(result) }
}
