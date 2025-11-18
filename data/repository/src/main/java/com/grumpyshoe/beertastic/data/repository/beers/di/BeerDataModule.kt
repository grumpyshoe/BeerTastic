
package com.grumpyshoe.beertastic.data.repository.beers.di

import com.grumpyshoe.beertastic.data.repository.beers.repository.BeerRepositoryImpl
import com.grumpyshoe.beertastic.data.source.network.di.NetworkModule
import com.grumpyshoe.beertastic.data.source.preferences.di.SharedPreferencesModule
import com.grumpyshoe.beertastic.domain.beer.repository.BeerRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val BeerDataModule =
    buildList {
        add(
            module {
                single<BeerRepository> { BeerRepositoryImpl(get(), get()) }
            },
        )
        addAll(NetworkModule)
        add(SharedPreferencesModule)
    }
