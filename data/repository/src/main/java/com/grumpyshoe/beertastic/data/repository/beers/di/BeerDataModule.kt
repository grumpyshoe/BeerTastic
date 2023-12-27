package com.grumpyshoe.beertastic.data.repository.beers.di

import com.grumpyshoe.beertastic.data.repository.beers.repository.BeerRepositoryImpl
import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BeerDataModule {

    @Provides
    fun providesBeerRepository(repository: BeerRepositoryImpl): BeerRepository {
        return repository
    }
}
