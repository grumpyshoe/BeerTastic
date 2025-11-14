package com.grumpyshoe.beertastic.data.source.network.di

import com.grumpyshoe.beertastic.data.source.network.BuildConfig
import com.grumpyshoe.beertastic.data.source.network.beer.di.BeerNetworkModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal val NetworkCoreModule =
    module {

        single { HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) } }
        single {
            OkHttpClient
                .Builder()
                .addInterceptor(get<HttpLoggingInterceptor>())
                .build()
        }
        single {
            Retrofit
                .Builder()
                .client(get<OkHttpClient>())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build()
        }
    }

val NetworkModule = NetworkCoreModule + BeerNetworkModule
