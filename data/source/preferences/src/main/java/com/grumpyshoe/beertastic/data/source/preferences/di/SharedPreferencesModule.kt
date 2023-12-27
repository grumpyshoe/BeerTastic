package com.grumpyshoe.beertastic.data.source.preferences.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.grumpyshoe.beertastic.data.source.preferences.SharedPreferenceService
import com.grumpyshoe.beertastic.data.source.preferences.SharedPreferenceServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Provides
    @Singleton
    fun providesSharedPrefs(@ApplicationContext context: Context): SharedPreferences {
        val masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        return EncryptedSharedPreferences.create(
            context.packageName + "_secure_preferences",
            masterKey,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    @Provides
    @Singleton
    fun provideSharedPreferenceService(encryptedSharedPrefs: SharedPreferences): SharedPreferenceService {
        return SharedPreferenceServiceImpl(encryptedSharedPrefs)
    }
}