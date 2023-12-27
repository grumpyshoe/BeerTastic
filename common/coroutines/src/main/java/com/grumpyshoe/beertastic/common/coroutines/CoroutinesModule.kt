package com.grumpyshoe.beertastic.common.coroutines

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object CoroutinesModule {

    @Singleton
    @Provides
    fun provideIoCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}
