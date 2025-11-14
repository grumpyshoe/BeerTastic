package com.grumpyshoe.beertastic

import android.app.Application
import com.grumpyshoe.beertastic.data.repository.beers.di.BeerDataModule
import com.grumpyshoe.beertastic.domain.beer.di.BeerDomainModule
import com.grumpyshoe.beertastic.presentation.features.details.viewmodel.DetailsViewModel
import com.grumpyshoe.beertastic.presentation.features.home.viewmodel.HomeViewModel
import com.grumpyshoe.beertastic.presentation.features.splashscreen.viewmodel.SplashViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppApplication)
            modules(
                BeerDomainModule +
                        BeerDataModule +
                        appModule,
            )
        }
    }

    val appModule = module {
        single<CoroutineDispatcher> { Dispatchers.IO }
        viewModelOf(::SplashViewModel)
        viewModelOf(::HomeViewModel)
        viewModelOf(::DetailsViewModel)
    }
}
