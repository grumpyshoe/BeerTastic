package com.grumpyshoe.beertastic.data.source.network.beer.di

import com.grumpyshoe.beertastic.data.source.network.beer.api.PunkAPI
import com.grumpyshoe.beertastic.data.source.network.beer.datasource.BeerRemoteDatasource
import com.grumpyshoe.beertastic.data.source.network.beer.datasource.BeerRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object BeerNetworkModule {

    @Singleton
    @Provides
    fun providePunkApi(retrofit: Retrofit): PunkAPI {
        return retrofit.create(PunkAPI::class.java)
    }

    @Provides
    fun providesBeerRemoteDatasource(
        dataSource: BeerRemoteDatasourceImpl,
    ): BeerRemoteDatasource {
        return dataSource
    }
}
