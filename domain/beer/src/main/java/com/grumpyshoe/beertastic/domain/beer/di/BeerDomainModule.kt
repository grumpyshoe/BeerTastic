package com.grumpyshoe.beertastic.domain.beer.di

import com.grumpyshoe.beertastic.domain.beer.usecase.GetBeerById
import com.grumpyshoe.beertastic.domain.beer.usecase.GetBeerByIdImpl
import com.grumpyshoe.beertastic.domain.beer.usecase.GetBeers
import com.grumpyshoe.beertastic.domain.beer.usecase.GetBeersImpl
import com.grumpyshoe.beertastic.domain.beer.usecase.GetFavorites
import com.grumpyshoe.beertastic.domain.beer.usecase.GetFavoritesImpl
import com.grumpyshoe.beertastic.domain.beer.usecase.IsBeerFavorite
import com.grumpyshoe.beertastic.domain.beer.usecase.IsBeerFavoriteImpl
import com.grumpyshoe.beertastic.domain.beer.usecase.SetIsBeerFavorite
import com.grumpyshoe.beertastic.domain.beer.usecase.SetIsBeerFavoriteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BeerDomainModule {

    @Binds
    fun bindsGetBeers(data: GetBeersImpl): GetBeers

    @Binds
    fun bindsGetBeerById(data: GetBeerByIdImpl): GetBeerById

    @Binds
    fun bindsIsBeerFavorite(data: IsBeerFavoriteImpl): IsBeerFavorite

    @Binds
    fun bindsSetIsBeerFavorite(data: SetIsBeerFavoriteImpl): SetIsBeerFavorite

    @Binds
    fun bindsGetFavorites(data: GetFavoritesImpl): GetFavorites
}
