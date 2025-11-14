
package com.grumpyshoe.beertastic.data.source.preferences.di

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.grumpyshoe.beertastic.data.source.preferences.SharedPreferenceService
import com.grumpyshoe.beertastic.data.source.preferences.SharedPreferenceServiceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val SharedPreferencesModule =
    module {

        single<SharedPreferences> {
            val masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
            EncryptedSharedPreferences.create(
                androidContext().packageName + "_secure_preferences",
                masterKey,
                androidContext(),
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
            )
        }

        single<SharedPreferenceService> {
            SharedPreferenceServiceImpl(get())
        }
    }
