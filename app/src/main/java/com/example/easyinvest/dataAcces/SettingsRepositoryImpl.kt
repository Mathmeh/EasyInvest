package com.example.easyinvest.dataAcces

import android.content.Context
import com.example.easyinvest.domain.SettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsRepositoryImpl
@Inject constructor(@ApplicationContext context: Context) : SettingsRepository {
    val sharedPref = context.getSharedPreferences(
        DEFAULT_CURRENCY_PREF_KEY, Context.MODE_PRIVATE
    )

    override suspend fun getDefaultCurrency(): String {
        return sharedPref.getString(DEFAULT_CURRENCY_PREF_KEY, "USD") ?: "USD"
    }

    override suspend fun setDefaultCurrency(curr: String) {
        sharedPref.edit().putString(DEFAULT_CURRENCY_PREF_KEY, curr).apply()
    }

    companion object {
        const val DEFAULT_CURRENCY_PREF_KEY = "currency_prefs"
    }
}
