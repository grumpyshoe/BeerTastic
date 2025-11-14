
package com.grumpyshoe.beertastic.data.source.network.beer.di

import com.grumpyshoe.beertastic.data.source.network.beer.api.PunkAPI
import com.grumpyshoe.beertastic.data.source.network.beer.datasource.BeerRemoteDatasource
import com.grumpyshoe.beertastic.data.source.network.beer.datasource.BeerRemoteDatasourceImpl
import org.koin.dsl.module
import retrofit2.Retrofit

internal val BeerNetworkModule =
    module {

        single<PunkAPI> {
            val retrofit: Retrofit = get()
            retrofit.create(PunkAPI::class.java)
        }

        factory<BeerRemoteDatasource> {
            BeerRemoteDatasourceImpl(get())
        }
    }
